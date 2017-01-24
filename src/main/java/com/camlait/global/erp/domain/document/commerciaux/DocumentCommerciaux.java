package com.camlait.global.erp.domain.document.commerciaux;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.tarif.PriceType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-commerciaux`")
public class DocumentCommerciaux extends Document {

    @Transient
    private String priceTypeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "priceTypeId")
    private PriceType priceType;

    public DocumentCommerciaux() {
        setTypeDocument(TypeDocuments.DOCUMENT_COMMERCIAUX);
    }

    @Override
    public void postConstructOperation() {
        setMagasinId(getMagasin().getMagasinId());
        setResponsableId(getResponsableDocument().getPartenaireId());
        setBmqId(getBmq() != null ? getBmq().getBmqId() : null);
        setInventaireId(getInventaire() != null ? getInventaire().getInventaireId() : null);
        setPriceTypeId(priceType.getPriceTypeId());
    }
}
