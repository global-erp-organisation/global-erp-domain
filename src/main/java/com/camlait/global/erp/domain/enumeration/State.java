package com.camlait.global.erp.domain.enumeration;

public enum State implements EnumTypeEntitity {

	ACTIVE("A"), INACTIVE("I"), VISIBLE("V"), INVISIBLE("IV");

	private final String type;

	private State(String type) {
		this.type = type;
	}

	@Override
	public EnumTypeEntitity getEnumType() {
		return this;
	}

	@Override
	public String getType() {
		return this.type;
	}
}
