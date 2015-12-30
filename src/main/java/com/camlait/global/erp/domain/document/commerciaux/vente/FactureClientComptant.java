package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class FactureClientComptant extends FactureClient {

	public FactureClientComptant() {
		setTypeDocument(TypeDocuments.FACTURE_COMPTANT);
	}
}
