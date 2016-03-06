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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class DocumentTransfert extends DocumentDeStock {
    
    @ManyToOne
    @JoinColumn(name = "magasinDestinationId")
    private Magasin magasinDestination;
     
    public DocumentTransfert() {
        setSensOperation(SensOperation.VIREMENT);
        setTypeDocument(TypeDocuments.TRANSFERT);
    }
}
