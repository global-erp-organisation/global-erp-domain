package com.camlait.global.erp.domain.enumeration;

public enum EvaluationMode implements EnumTypeEntitity {

	PER_PERCENTAGE("P", "Percentage"), PER_VALUE("V", "Value");

	private final String type;
	private final String id;

	private EvaluationMode(String id, String type) {
		this.id = id;
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

	public String getId() {
		return id;
	}
}
