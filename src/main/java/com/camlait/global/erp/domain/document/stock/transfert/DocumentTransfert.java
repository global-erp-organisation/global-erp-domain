package com.camlait.global.erp.domain.document.stock.transfert;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class DocumentTransfert extends DocumentDeStock {
    
    @Transient
    private Long magasinDestinationId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinDestinationId")
    private Magasin magasinDestination;
     
    public DocumentTransfert() {
        setSensOperation(SensOperation.VIREMENT);
        setTypeDocument(TypeDocuments.TRANSFERT);
    }
}
