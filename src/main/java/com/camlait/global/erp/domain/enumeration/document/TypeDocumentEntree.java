package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentEntree implements EnumTypeEntite{
	BON_ENTREE("BE"), BON_RETOUR("BR");

	private final String type;

	private TypeDocumentEntree(String type) {
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
