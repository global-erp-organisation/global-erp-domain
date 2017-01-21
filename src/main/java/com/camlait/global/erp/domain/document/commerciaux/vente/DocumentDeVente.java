package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.DocumentCommerciaux;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.localisation.Zone;
import com.camlait.global.erp.domain.partenaire.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`doc-document-de-ventes`")
public abstract class DocumentDeVente extends DocumentCommerciaux {
    
    @Transient
    private String clientId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    
    @Transient
    private String zoneId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;
    
    private boolean documentSolde;
        
    public DocumentDeVente() {
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.DOCUMENT_DE_VENTE);
    } 
    
	@Override
	public void postConstructOperation() {
		setMagasinId(getMagasin().getMagasinId());
		setResponsableId(getResponsableDocument().getPartenaireId());
		setBmqId(getBmq() != null ? getBmq().getBmqId() : null);
		setInventaireId(getInventaire() != null ? getInventaire().getInventaireId() : null);
		setClientId(client.getPartenaireId());
		setZoneId(zone.getLocalId());
	}

}
