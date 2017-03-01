package com.camlait.global.erp.domain.document.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.tarif.PriceType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-business`")
public class BusinessDocument extends Document {

    @Transient
    private String priceTypeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "priceTypeId")
    private PriceType priceType;

    public BusinessDocument() {
        setDocumentType(DocumentType.DOCUMENT_COMMERCIAUX);
    }

    @Override
    public void postConstructOperation() {
        setStoreId(getStore().getStoreId());
        setWorkerId(getDocumentWorker().getPartnerId());
        setDmId(getDailyMovement() != null ? getDailyMovement().getDmId() : null);
        setInventoryId(getInventory() != null ? getInventory().getInventoryId() : null);
        setPriceTypeId(priceType.getPriceTypeId());
    }
}
