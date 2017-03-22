package com.camlait.global.erp.domain.enumeration;

public enum RegulationCondition implements EnumTypeEntitity {
	JOURS_NET("Jour(s) net");

	private final String type;

	private RegulationCondition(String type) {
		this.type = type;
	}

	@Override
	public EnumTypeEntitity getEnumType() {
		return this;
	}

	@Override
	public String getType() {
		return type;
	}

}
