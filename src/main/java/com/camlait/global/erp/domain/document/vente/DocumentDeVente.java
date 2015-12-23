package com.camlait.global.erp.domain.document.vente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.localisation.Zone;
import com.camlait.global.erp.domain.partenaire.Client;

@Entity
public class DocumentDeVente extends Document {

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
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
		setTypeDocument(TypeDocuments.FACTURE_CLIENT);
	}

}
