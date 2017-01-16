package com.camlait.global.erp.domain.enumeration;

public enum Etat implements EnumTypeEntite {

	ACTIF("A"), INACTIF("I"), VISIBLE("V"), INVISIBLE("IV");

	private final String type;

	private Etat(String type) {
		this.type = type;
	}

	@Override
	public EnumTypeEntite getEnumType() {
		return this;
	}

	@Override
	public String getType() {
		return this.type;
	}
}
