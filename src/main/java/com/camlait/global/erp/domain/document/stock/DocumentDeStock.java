package com.camlait.global.erp.domain.document.stock;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class DocumentDeStock extends Document {

	public DocumentDeStock() {
		setTypeDocument(TypeDocuments.DOCUMENT_DE_STOCK);
	}

}
