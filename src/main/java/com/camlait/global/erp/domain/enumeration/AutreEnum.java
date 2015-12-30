package com.camlait.global.erp.domain.enumeration;

import com.camlait.global.erp.domain.enumeration.document.EnumTypeEntite;

public enum AutreEnum implements EnumTypeEntite {
	INVENTAIRE("INV"), CLIENT("CL"), 
	VENDEUR("VE"), EMPLOYE("EM"), 
	CAISSIER("CA"), CLIENT_COMPTANT("CC"), 
	MAGASINIER("MA"),CLIENT_A_MARGE("CM");

	private final String type;

	private AutreEnum(String type) {
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
