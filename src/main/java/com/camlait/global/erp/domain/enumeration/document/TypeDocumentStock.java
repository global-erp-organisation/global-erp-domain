package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentStock {

	DOCUMENT_ENTREE("DE"), DOCUMENT_SORTIE("DS"), TRANSFERT("VD");

	private final String type;

	private TypeDocumentStock(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
