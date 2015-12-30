package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class FactureMarge extends FactureClient {

	public FactureMarge() {
		setTypeDocument(TypeDocuments.FACTURE_MARGE);
	}
}
