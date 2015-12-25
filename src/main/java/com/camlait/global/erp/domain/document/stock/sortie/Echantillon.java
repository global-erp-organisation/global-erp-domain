package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class Echantillon extends DocumentDeSortie {

	public Echantillon(){
		setTypeDocument(TypeDocuments.ECHATILLON);
	}
}
