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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = "documentDetails")
@Table(name = "`doc-documents`")
@ToString(exclude = "documentDetails")
public abstract class Document extends BaseEntity {

    @Id
    private String documentId;

    @Column(unique = true, nullable = false)
    private String documentCode;

    private Date documentDate;

    @Transient
    private String storeId;

    @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Transient
    private String workerId;

    @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "workerId")
    private Employee documentWorker;

    @Enumerated(EnumType.STRING)
    private OperationDirection operationDirection;

    @Transient
    private String dmId;

    @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "dmId")
    private DailyMovement dailyMovement;

    @Transient
    private String inventoryId;

    @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;

    @JsonManagedReference
    
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
    public void postConstructOperation() {
        setStoreId(store.getStoreId());
        setWorkerId(documentWorker.getPartnerId());
        setDmId(dailyMovement != null ? dailyMovement.getDmId() : null);
        setInventoryId(inventory != null ? inventory.getInventoryId() : null);
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

    /**
     * Add a document detail into the current collection of document detail.
     * 
     * @param line
     * @return
     */
    public Document addLine(DocumentDetails line) {
        this.documentDetails.add(line);
        return this;
    }
    
    /**
     * remove a document detail into the current collection of document detail.
     * 
     * @param line
     * @return
     */
    public Document removeLine(DocumentDetails line) {
        this.documentDetails.remove(line);
        return this;
    }
}
