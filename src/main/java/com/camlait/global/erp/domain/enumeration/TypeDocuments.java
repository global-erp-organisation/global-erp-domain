package com.camlait.global.erp.domain.enumeration;

public enum TypeDocuments implements EnumTypeEntite {

	DOCUMENT_DE_STOCK("DS"), 
	DOCUMENT_COMMERCIAUX("DC"),
	DOCUMENT_DE_VENTE("DV"), 
	DOCUMENT_ACHAT("DA"),
	FACTURE_CLIENT("FA"),
	FACTURE_COMPTANT("FC"), 
	FACTURE_MARGE("FM"), 
	FACTURE_CREDIT("FT"),
	DOCUMENT_ENTREE("DE"), 
	DOCUMENT_SORTIE("DS"), 
	TRANSFERT("VD"),
	BON_DE_SORTIE("BS"), 
	ECHANTILLON("EC"), 
	DON("DN"), 
	ANIMATION("AN"), 
	AVARIE("AV"),
	BON_ENTREE("BE"), 
	BON_DE_RETOUR("BR");

	private final String type;

	private TypeDocuments(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public EnumTypeEntite getEnumType() {
		return this;
	}

}
