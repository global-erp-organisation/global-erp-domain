package com.camlait.global.erp.domain.document.commerciaux.vente;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FactureMarge extends FactureClient {

	public FactureMarge() {
		setTypeDocument(TypeDocuments.FACTURE_MARGE);
	}
}
