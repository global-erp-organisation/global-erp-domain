package com.camlait.global.erp.domain.enumeration;

public enum ConditionReglement implements EnumTypeEntite {
	JOURS_NET("Jour(s) net");

	private final String type;

	private ConditionReglement(String type) {
		this.type = type;
	}

	@Override
	public EnumTypeEntite getEnumType() {
		return this;
	}

	@Override
	public String getType() {
		return type;
	}

}
