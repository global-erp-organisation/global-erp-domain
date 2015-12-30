package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeFacture;

@Entity
public class FactureClientComptant extends FactureClient {

	public FactureClientComptant() {
		setTypeFacture(TypeFacture.FACTURE_COMPTANT);
	}
}
