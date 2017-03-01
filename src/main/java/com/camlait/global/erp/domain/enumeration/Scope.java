package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum Scope {
	DETAIL("D", "Detail"), 
	TOTAL("T", "Total"),
	UNKNOWN("U", "Unknown");

	private final String scopeId;

	private final String scopeDescription;

	public String getScopeId() {
		return scopeId;
	}

	public String getScopeDescription() {
		return scopeDescription;
	}

	private Scope(String id, String description) {
		this.scopeId = id;
		this.scopeDescription = description;
	}

	public static Scope retrouverPortee(String description) {
		return Stream.of(values()).filter((p) -> p.getScopeDescription().equalsIgnoreCase(description)).findFirst()
				.orElse(UNKNOWN);
	}
}
