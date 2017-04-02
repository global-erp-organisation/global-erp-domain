package com.camlait.global.erp.domain.enumeration;

public enum DocumentType implements EnumTypeEntitity {

	STOCK_DOCUMENT("DS"), 
	BUSINESS_DOCUMENT("DC"),
	SALE_DOCUMENT("DV"), 
	PURCHASE_DOCUMENT("DA"),
	CLIENT_BILL("FA"),
	CASH_BILL("FC"), 
	MARGIN_BILL("FM"), 
	CREDIT_BILL("FT"),
	IN_DOCUMENT("DE"), 
	OUT_DOCUMENT("DS"), 
	STAGING_DOCUMENT("VD"),
	BON_DE_SORTIE("BS"), 
	ECHANTILLON("EC"), 
	DON("DN"), 
	ANIMATION("AN"), 
	AVARIE("AV"),
	BON_ENTREE("BE"), 
	BON_DE_RETOUR("BR");

	private final String type;

	private DocumentType(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public EnumTypeEntitity getEnumType() {
		return this;
	}

}
