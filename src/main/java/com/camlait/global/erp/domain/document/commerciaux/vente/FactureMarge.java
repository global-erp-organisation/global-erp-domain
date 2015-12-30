package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeFacture;

@Entity
public class FactureMarge extends FactureClient {

	public FactureMarge() {
		setTypeFacture(TypeFacture.FACTURE_MARGE);
	}
}
