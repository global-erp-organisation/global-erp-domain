package com.camlait.global.erp.domain.document.stock;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentStock;
import com.camlait.global.erp.domain.enumeration.document.TypeDocuments;

@Entity
public class DocumentDeStock extends Document {

	@Enumerated(EnumType.STRING)
	private TypeDocumentStock typeDocumentStock;

	public TypeDocumentStock getTypeDocumentStock() {
		return typeDocumentStock;
	}

	public void setTypeDocumentStock(TypeDocumentStock typeDocumentStock) {
		this.typeDocumentStock = typeDocumentStock;
	}

	public DocumentDeStock() {
		setTypeDocument(TypeDocuments.DOCUMENT_DE_STOCK);
	}

}
