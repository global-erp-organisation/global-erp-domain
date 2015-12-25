package com.camlait.global.erp.domain.enumeration;

public enum TypeDocuments {

	FACTURE_CLIENT("FA"), BON_ENTREE("BE"), BON_SORTIE("BS"), DON("DON"), ECHATILLON("EC"), ANIMATION("AN"), VIREMENT(
			"VD"), DOCUMENT_SORTIE("DS"), DOCUMENT_ENTREE("DE"), DOCUMENT_DE_VENTE("DV");
	private final String type;

	private TypeDocuments(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
