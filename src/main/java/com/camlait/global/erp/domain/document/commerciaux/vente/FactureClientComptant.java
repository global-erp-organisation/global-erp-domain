package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FactureClientComptant extends FactureClient {

	public FactureClientComptant() {
		setTypeDocument(TypeDocuments.FACTURE_COMPTANT);
	}
}
