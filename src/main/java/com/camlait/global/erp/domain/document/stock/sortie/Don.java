package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeDocumentSortie;

@Entity
public class Don extends DocumentDeSortie {

	public Don() {
		setTypeDocumentSortie(TypeDocumentSortie.DON);
	}
}
