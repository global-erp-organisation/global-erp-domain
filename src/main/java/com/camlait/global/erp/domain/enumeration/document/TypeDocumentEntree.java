package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentEntree {
	BON_ENTREE("BE"), BON_RETOUR("BR");

	private final String type;

	private TypeDocumentEntree(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
