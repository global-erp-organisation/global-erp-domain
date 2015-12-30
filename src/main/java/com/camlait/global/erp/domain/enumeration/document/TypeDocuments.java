package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocuments {

	DOCUMENT_DE_STOCK("DS"), DOCUMENT_COMMERCIAUX("DC");

	private final String type;

	private TypeDocuments(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
