package com.camlait.global.erp.domain.enumeration.document;

public enum TypeDocumentSortie {

	BON_DE_SORTIE("BS"), ECHANTILLON("EC"), DON("DN"), ANIMATION("AN"), AVARIE("AV");
	private final String type;

	private TypeDocumentSortie(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
