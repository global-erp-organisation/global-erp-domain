package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeDocumentEntree;

@Entity
public class BonDeRetour extends DocumentEntree {

	public BonDeRetour() {
		setTypeDocumentEntree(TypeDocumentEntree.BON_RETOUR);
	}
}
