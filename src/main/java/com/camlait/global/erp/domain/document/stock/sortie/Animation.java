package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class Animation extends DocumentDeSortie {
	public Animation() {
		setTypeDocument(TypeDocuments.ANIMATION);
	}

}
