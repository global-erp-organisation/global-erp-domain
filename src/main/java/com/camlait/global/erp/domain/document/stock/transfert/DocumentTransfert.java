package com.camlait.global.erp.domain.document.stock.transfert;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`doc-document-de-transferts`")
public class DocumentTransfert extends DocumentDeStock {

    @Transient
    private String magasinDestinationId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinDestinationId")
    private Magasin magasinDestination;

    public DocumentTransfert() {
        setSensOperation(SensOperation.VIREMENT);
        setTypeDocument(TypeDocuments.TRANSFERT);
    }

    @Override
    public void postConstructOperation() {
        setMagasinId(getMagasin().getMagasinId());
        setResponsableId(getResponsableDocument().getPartenaireId());
        setBmqId(getBmq() != null ? getBmq().getBmqId() : null);
        setInventaireId(getInventaire() != null ? getInventaire().getInventaireId() : null);
        setMagasinDestinationId(magasinDestination.getMagasinId());
    }
}
