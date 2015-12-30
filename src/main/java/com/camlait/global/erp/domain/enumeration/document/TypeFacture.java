package com.camlait.global.erp.domain.enumeration.document;

public enum TypeFacture implements EnumTypeEntite{

	FACTURE_COMPTANT("FC"), FACTURE_MARGE("FM"), FACTURE_CREDIT("FT");

	private final String type;

	private TypeFacture(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public EnumTypeEntite getEnumType() {
		return this;
	}

}
