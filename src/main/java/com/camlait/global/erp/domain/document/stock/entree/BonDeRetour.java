package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class BonDeRetour extends DocumentEntree {

	public BonDeRetour() {
		setTypeDocument(TypeDocuments.BON_DE_RETOUR);
	}
}
