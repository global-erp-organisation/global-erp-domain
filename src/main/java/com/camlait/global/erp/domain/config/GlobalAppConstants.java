package com.camlait.global.erp.domain.config;

public class GlobalAppConstants {

	private GlobalAppConstants() {

	}

	public final static String DAO_BASE_PACKAGE = "com.camlait.global.erp.dao";
	public final static String DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain";
	public final static String SERVICE_BASE_PACKAGE = "com.camlait.global.erp.service";

	// Domain base packages
	public final static String PRODUCT_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.produit";
	public final static String DOCUMENT_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.document";
	public final static String AUTH_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.auth";
	public final static String STORE_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.entrepot";
	public final static String IMMO_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.immobilisation";
	public final static String INVENTORY_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.inventaire";
	public final static String LOCAL_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.localisation";
	public final static String OPERATION_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.operation";
	public final static String PARTNER_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.partenaire";
	public final static String BMQ_DOMAIN_BASE_PACKAGE = "com.camlait.global.erp.domain.bmq";

	// Repository base packages
	public final static String PRODUCT_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.produit";
	public final static String DOCUMENT_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.document";
	public final static String AUTH_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.auth";
	public final static String STORE_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.entrepot";
	public final static String IMMO_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.immobilisation";
	public final static String INVENTORY_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.inventaire";
	public final static String LOCAL_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.localisation";
	public final static String OPERATION_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.operation";
	public final static String PARTNER_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.partenaire";
	public final static String BMQ_DAO_BASE_PACKAGE = "com.camlait.global.erp.dao.bmq";

	
	public static String buildNotFingMessage(Class<?> objectType, Object value) {
		return "L'objet de type " + objectType.getCanonicalName() + " ayant l'identifiant " + String.valueOf(value)
				+ " n'existe pas";
	}
}
