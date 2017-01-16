package com.camlait.global.erp.domain.enumeration;

public enum ModeleEvaluation implements EnumTypeEntite {

	PAR_POURCENTAGE("P", "Pourcentage"), PAR_VALEUR("V", "Valeur");

	private final String type;
	private final String id;

	private ModeleEvaluation(String id, String type) {
		this.id = id;
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

	public String getId() {
		return id;
	}
}
