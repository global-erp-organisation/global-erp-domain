package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentEntree;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentStock;

@Entity
public class DocumentEntree extends DocumentDeStock {

	@Enumerated(EnumType.STRING)
	private TypeDocumentEntree typeDocumentEntree;

	public TypeDocumentEntree getTypeDocumentEntree() {
		return typeDocumentEntree;
	}

	public void setTypeDocumentEntree(TypeDocumentEntree typeDocumentEntree) {
		this.typeDocumentEntree = typeDocumentEntree;
	}

	public DocumentEntree() {
		setSensOperation(SensOperation.ENTREE);
		setTypeDocumentStock(TypeDocumentStock.DOCUMENT_ENTREE);
	}
}
