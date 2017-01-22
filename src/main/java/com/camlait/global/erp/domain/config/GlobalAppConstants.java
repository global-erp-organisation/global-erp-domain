package com.camlait.global.erp.domain.config;

import java.util.function.Function;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.LigneDeDocument;
import com.camlait.global.erp.domain.exception.GlobalErpServiceException;

public class GlobalAppConstants {

	private GlobalAppConstants() {

	}

	public final static String ROOT_PACKAGE = "com.camlait.global.erp";

	public final static String DAO_BASE_PACKAGE = ROOT_PACKAGE + ".dao";
	public final static String DOMAIN_BASE_PACKAGE = ROOT_PACKAGE + ".domain";
	public final static String SERVICE_BASE_PACKAGE = ROOT_PACKAGE + ".delegate";

	// Domain base packages
	public final static String PRODUCT_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".produit";
	public final static String DOCUMENT_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".document";
	public final static String AUTH_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".auth";
	public final static String STORE_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".entrepot";
	public final static String IMMO_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".immobilisation";
	public final static String INVENTORY_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".inventaire";
	public final static String LOCAL_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".localisation";
	public final static String OPERATION_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".operation";
	public final static String PARTNER_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".partenaire";
	public final static String BMQ_DOMAIN_BASE_PACKAGE = DOMAIN_BASE_PACKAGE + ".bmq";

	// Repository base packages
	public final static String PRODUCT_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".produit";
	public final static String DOCUMENT_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".document";
	public final static String AUTH_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".auth";
	public final static String STORE_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".entrepot";
	public final static String IMMO_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".immobilisation";
	public final static String INVENTORY_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".inventaire";
	public final static String LOCAL_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".localisation";
	public final static String OPERATION_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".operation";
	public final static String PARTNER_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".partenaire";
	public final static String BMQ_DAO_BASE_PACKAGE = ROOT_PACKAGE + DAO_BASE_PACKAGE + ".bmq";

	public final static String HASH_ALGORITHM = "SHA1PRNG";

	public static void verifyIllegalArgumentException(Object fieldValue, String fieldName) {
		if (fieldValue == null) {
			throw new IllegalArgumentException(buildIllegalArgumentMessage(fieldName));
		}
	}

	public static void verifyObjectNoFindException(Object fieldValue, Class<?> objectType, Object fieldName) {
		if (fieldValue == null) {
			throw new GlobalErpServiceException(buildNotFindMessage(objectType, fieldName));

		}
	}

	private static String buildNotFindMessage(Class<?> objectType, Object value) {
		return "L'objet " + objectType.getCanonicalName() + " ayant l'identifiant " + String.valueOf(value)
				+ " n'existe pas";
	}

	private static String buildIllegalArgumentMessage(String object) {
		return "L'Objet " + object + " ne peut pas etre null";
	}

	public static String unavailableProductMessage(LigneDeDocument ligne) {
		String message = "";
		message = "The product " + ligne.getProduit().getDescriptionProduit() + " is not available." + " Only "
				+ ligne.getProduit().availableQuantity(ligne.getDocument().getMagasin()) + " is available";
		return message;
	}

	public static Entite verifyIllegalArgumentException(Object fieldValue, String fieldName,
			Function<Object, Entite> function) {
		verifyIllegalArgumentException(fieldValue, fieldName);
		return function.apply(fieldValue);
	}
}
