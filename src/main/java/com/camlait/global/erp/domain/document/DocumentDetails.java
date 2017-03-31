package com.camlait.global.erp.domain.document;

import static com.camlait.global.erp.domain.config.GlobalAppConstants.unavailableProductMessage;

import java.util.Date;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.exception.DataStorageException;
import com.camlait.global.erp.domain.inventory.Stock;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.util.Helper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = "documentDetailsTaxes")
@ToString(exclude = "documentDetailsTaxes")
@Builder
@Table(name = "`doc-document-details`")
public class DocumentDetails extends BaseEntity {

    @Id
    private String docDetailId;

    @Transient
    private String productId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produitId")
    private Product product;

    private Long lineQuantity;

    private double lineUnitPrice;

    @Transient
    private String documenId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentId")
    private Document document;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @Enumerated(EnumType.STRING)
    private OperationDirection operationDirection;

    @JsonManagedReference
    @OneToMany(mappedBy = "documentDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DocumentDetailsTax> documentDetailsTaxes = Sets.newHashSet();

    @Transient
    @JsonIgnore
    private DocumentDetails oldRecord;

    public DocumentDetails() {
    }

    public boolean isStorable() {
        if (!this.getProduct().isStockFollowing()) {
            return true;
        }
        return this.getProduct().availableQuantity(this.getDocument().getStore()) - this.getLineQuantity() > 0;
    }

    @PrePersist
    private void setKey() {
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
        if (isStorable()) {
            setDocDetailId(Helper.getUidFor(docDetailId));
            buildTaxes();
        } else {
            throw new DataStorageException(unavailableProductMessage(this));
        }
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
        setOldRecord(this);
    }

    /**
     * Built the tax details for the current object.
     * 
     * @return The current object with associated tax details.
     */
    public DocumentDetails buildTaxes() {
        if (document != null && document.isBusinessDocument()) {
            final Set<Tax> taxes = this.getProduct().getTaxes();
            if (CollectionUtils.isNullOrEmpty(taxes)) {
                final Set<DocumentDetailsTax> lt = taxes.stream().map(t -> {
                    return DocumentDetailsTax.builder()
                            .documentDetails(this)
                            .docDetailId(this.getDocDetailId())
                            .taxRate(t.getPercentageValue())
                            .tax(t)
                            .taxId(t.getTaxId())
                            .build();
                }).collect(Collectors.toSet());
                setDocumentDetailsTaxes(lt);
            }
        }
        return this;
    }

    @Override
    public void postConstructOperation() {
        setProductId(product.getProductId());
        setDocumenId(document.getDocumentId());
    }

    @PreRemove
    private void setTheoldRecord() {
        setOldRecord(this);
    }

    @PostRemove
    private void postRemove() {
        if (oldRecord != null) {
            updateStock(getStock(), this.lineQuantity, (s, q) -> {
                if (document.getOperationDirection().equals(OperationDirection.IN)) {
                    s.setAvailableQuantity(s.getAvailableQuantity() - q);
                } else {
                    s.setAvailableQuantity(s.getAvailableQuantity() + q);
                }
            });
            setOldRecord(null);
        }
    }

    @PostPersist
    private void postPersist() {
        updateStock(getStock(), this.lineQuantity, (s, q) -> {
            if (document.getOperationDirection().equals(OperationDirection.IN)) {
                s.setAvailableQuantity(s.getAvailableQuantity() + q);
            } else {
                s.setAvailableQuantity(s.getAvailableQuantity() - q);
            }
        });
    }

    @PostUpdate
    private void postUpdate() {
        if (oldRecord != null) {
            updateStock(getStock(), this.lineQuantity, (s, q) -> {
                if (document.getOperationDirection().equals(OperationDirection.IN)) {
                    s.setAvailableQuantity(s.getAvailableQuantity() - oldRecord.getLineQuantity() + q);
                } else {
                    s.setAvailableQuantity(s.getAvailableQuantity() + oldRecord.getLineQuantity() - q);
                }
            });
            setOldRecord(null);
        }
    }

    private void updateStock(Stock stock, Long quantity, BiConsumer<Stock, Long> updateConsumer) {
        if (document.stockAffects()) {
            if (stock != null) {
                updateConsumer.accept(stock, quantity);
            }
        }
    }

    private Stock getStock() {
        return this.getProduct().getStockByStore(document.getStore());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
