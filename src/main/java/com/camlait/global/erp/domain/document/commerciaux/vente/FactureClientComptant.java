package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`doc-facture-comptants`")
public class FactureClientComptant extends FactureClient {

	public FactureClientComptant() {
		setTypeDocument(TypeDocuments.FACTURE_COMPTANT);
	}
}
