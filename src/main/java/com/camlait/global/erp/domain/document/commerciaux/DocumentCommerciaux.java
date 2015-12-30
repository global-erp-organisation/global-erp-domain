package com.camlait.global.erp.domain.document.commerciaux;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentCommerciaux;
import com.camlait.global.erp.domain.enumeration.document.TypeDocuments;

@Entity
public  class DocumentCommerciaux extends Document {

	@Enumerated(EnumType.STRING)
	private TypeDocumentCommerciaux typeDocumentCommerciaux;

	public TypeDocumentCommerciaux getTypeDocumentCommerciaux() {
		return typeDocumentCommerciaux;
	}

	public void setTypeDocumentCommerciaux(TypeDocumentCommerciaux typeDocumentCommerciaux) {
		this.typeDocumentCommerciaux = typeDocumentCommerciaux;
	}
	
	public DocumentCommerciaux(){
		setTypeDocument(TypeDocuments.DOCUMENT_COMMERCIAUX);
	}
}
