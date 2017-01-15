package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.DocumentCommerciaux;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.organisation.Zone;
import com.camlait.global.erp.domain.partenaire.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class DocumentDeVente extends DocumentCommerciaux {
    
    @Transient
    private Long clientId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    
    @Transient
    private Long zoneId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;
    
    private boolean documentSolde;
        
    public DocumentDeVente() {
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.DOCUMENT_DE_VENTE);
    }    
}
