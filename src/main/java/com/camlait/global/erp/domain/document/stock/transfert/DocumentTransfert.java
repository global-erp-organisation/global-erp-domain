package com.camlait.global.erp.domain.document.stock.transfert;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class DocumentTransfert extends DocumentDeStock {
    
    @ManyToOne
    @JoinColumn(name = "magasinDestinationId")
    private Magasin magasinDestination;
    
    public Magasin getMagasinDestination() {
        return magasinDestination;
    }
    
    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }
    
    public DocumentTransfert() {
        setSensOperation(SensOperation.VIREMENT);
        setTypeDocument(TypeDocuments.TRANSFERT);
    }
}
