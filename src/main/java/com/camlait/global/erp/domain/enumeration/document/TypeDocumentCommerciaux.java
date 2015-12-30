package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentCommerciaux {

	DOCUMENT_DE_VENTE("DV"), DOCUMENT_ACHAT("DA");

	private final String type;

	private TypeDocumentCommerciaux(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
