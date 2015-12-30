package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentVente {
	FACTURE_CLIENT("FA");

	private final String type;

	private TypeDocumentVente(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
