package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum Portee {
	DETAIL("D", "Detail"), TOTAL("T", "Total");

	private final String porteeId;

	private final String descriptionPortee;

	public String getPorteeId() {
		return porteeId;
	}

	public String getDescriptionPortee() {
		return descriptionPortee;
	}

	private Portee(String id, String description) {
		this.porteeId = id;
		this.descriptionPortee = description;
	}

	public static Portee retrouverPortee(String description) {
		return Stream.of(values()).filter((p) -> p.getDescriptionPortee().equals(description)).findFirst()
				.orElse(DETAIL);
	}
}
