package com.camlait.global.erp.domain.enumeration.document;

public enum TypeVente {
	COMPTANT("Comptant"), CREDIT("Credit");

	private final String description;

	private TypeVente(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
