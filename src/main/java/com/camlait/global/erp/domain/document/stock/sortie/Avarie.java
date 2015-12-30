package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class Avarie extends DocumentDeSortie {

	public Avarie() {
		setTypeDocument(TypeDocuments.AVARIE);
	}
}
