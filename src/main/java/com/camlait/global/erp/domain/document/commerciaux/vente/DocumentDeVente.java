package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.document.commerciaux.DocumentCommerciaux;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.organisation.Zone;
import com.camlait.global.erp.domain.partenaire.Client;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class DocumentDeVente extends DocumentCommerciaux {
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;
    
    private boolean documentSolde;
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public boolean isDocumentSolde() {
        return documentSolde;
    }
    
    public void setDocumentSolde(boolean documentSolde) {
        this.documentSolde = documentSolde;
    }
    
    public Zone getZone() {
        return zone;
    }
    
    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    public DocumentDeVente() {
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.DOCUMENT_DE_VENTE);
    }    
}
