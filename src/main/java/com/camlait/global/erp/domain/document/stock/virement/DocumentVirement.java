package com.camlait.global.erp.domain.document.stock.virement;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentStock;

@Entity
public class DocumentVirement extends DocumentDeStock {

	@ManyToOne
	@JoinColumn(name = "magasinDestinationId")
	private Magasin magasinDestination;

	public Magasin getMagasinDestination() {
		return magasinDestination;
	}

	public void setMagasinDestination(Magasin magasinDestination) {
		this.magasinDestination = magasinDestination;
	}

	public DocumentVirement() {
		setSensOperation(SensOperation.VIREMENT);
		setTypeDocumentStock(TypeDocumentStock.TRANSFERT);
	}
}
