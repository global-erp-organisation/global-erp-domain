package com.camlait.global.erp.domain.document;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.dm.DailyMovement;
import com.camlait.global.erp.domain.document.business.BusinessDocument;
import com.camlait.global.erp.domain.document.business.sale.CashClientBill;
import com.camlait.global.erp.domain.document.business.sale.ClientBill;
import com.camlait.global.erp.domain.document.business.sale.MargingBill;
import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.document.stock.StockDocument;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.exception.DataStorageException;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.inventory.Inventory;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.warehouse.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, exclude = "documentDetails")
@Table(name = "`doc-documents`")
@ToString(exclude = "documentDetails")
public abstract class Document extends BaseEntity {

    @Id
    private String documentId;

    @Column(unique = true, nullable = false)
    private String documentCode;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date documentDate;

    @Transient
    private String storeId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "storeId")
    private Store store;

    @Transient
    private String workerId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "workerId")
    private Employee documentWorker;

    @Enumerated(EnumType.STRING)
    private OperationDirection operationDirection;

    @Transient
    private String dmId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "dmId")
    private DailyMovement dailyMovement;

    @Transient
    private String inventoryId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Collection<DocumentDetails> documentDetails = Lists.newArrayList();

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    public Document() {
    }

    public boolean isClientBill() {
        return this instanceof ClientBill;
    }

    public boolean isCashBill() {
        return this instanceof CashClientBill;
    }

    public boolean isMarginBill() {
        return this instanceof MargingBill;
    }

    public boolean isSaleDocument() {
        return this instanceof SaleDocument;
    }

    public boolean isBusinessDocument() {
        return this instanceof BusinessDocument;
    }

    public boolean stockAffects() {
        return (this instanceof StockDocument) || (this instanceof ClientBill);
    }

    @PrePersist
    private void setKey() {
        if (!CollectionUtils.isNullOrEmpty(documentDetails)) {
            setDocumentId(EntityHelper.getUidFor(documentId));
        } else {
            throw new DataStorageException("Unable to store a document with no detail.");
        }
    }

    @Override
    public Document init() {
        setStoreId(store == null ? null : store.getStoreId());
        setWorkerId(documentWorker == null ? null : documentWorker.getPartnerId());
        setDmId(dailyMovement != null ? dailyMovement.getDmId() : null);
        setInventoryId(inventory != null ? inventory.getInventoryId() : null);
        setDocumentDetails(EntityHelper.batchInit(documentDetails));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

    /**
     * remove a document detail into the current collection of document detail.
     * 
     * @param line
     * @return
     */
    public Document removeLine(DocumentDetails line) {
        if (!CollectionUtils.isNullOrEmpty(documentDetails)) {
            this.documentDetails.remove(line);
        }
        return this;
    }

    /**
     * Computes the value without taxes for the current document.
     * 
     * @return The value without taxes for the current document.
     */

    public Double documentValueWithoutTaxes() {
        return this.getDocumentDetails().stream().mapToDouble(l -> {
            return l.getLineUnitPrice() * l.getLineQuantity();
        }).sum();
    }

    /**
     * Computes the taxes value for the current document.
     * 
     * @return The total taxes value that belong to the current document.
     */
    public Double documentTaxesValue() {
        return this.getDocumentDetails().stream().mapToDouble(l -> {
            return l.getDocumentDetailsTaxes().stream().mapToDouble(ldt -> {
                return l.getLineUnitPrice() * l.getLineQuantity() * ldt.getTaxRate();
            }).sum();
        }).sum();
    }

    /**
     * Computes the taxes value for the current document.
     * 
     * @param taxId Tax identifier.
     * @return The total tax value for the given tax and the current document.
     */
    public Double documentTaxesValue(final String taxId) {
        return this.getDocumentDetails().stream().mapToDouble(ld -> {
            return ld.getDocumentDetailsTaxes().stream().filter(ldt -> ldt.getTax().getTaxId().equals(taxId)).mapToDouble(ldt -> {
                return ld.getLineUnitPrice() * ld.getLineQuantity() * ldt.getTaxRate();
            }).sum();
        }).sum();
    }

    /**
     * Computes the document value including taxes value.
     * 
     * @return The document value including taxes value.
     */
    public Double documentValueWithTaxes() throws DataStorageException {
        return documentValueWithoutTaxes() + documentTaxesValue();
    }
}
