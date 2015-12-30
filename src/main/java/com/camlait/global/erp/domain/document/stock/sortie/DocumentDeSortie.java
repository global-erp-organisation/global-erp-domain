package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentSortie;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentStock;

@Entity
public class DocumentDeSortie extends DocumentDeStock {

	@Enumerated(EnumType.STRING)
	private TypeDocumentSortie typeDocumentSortie;

	public TypeDocumentSortie getTypeDocumentSortie() {
		return typeDocumentSortie;
	}

	public void setTypeDocumentSortie(TypeDocumentSortie typeDocumentSortie) {
		this.typeDocumentSortie = typeDocumentSortie;
	}

	public DocumentDeSortie() {
		setSensOperation(SensOperation.SORTIE);
		setTypeDocumentStock(TypeDocumentStock.DOCUMENT_SORTIE);
	}
}
