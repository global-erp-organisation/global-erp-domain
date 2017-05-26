package com.camlait.global.erp.domain.config;

import com.camlait.global.erp.domain.document.DocumentDetails;

public class GlobalAppConstants {

    private GlobalAppConstants() {

    }

    public final static String ROOT_PACKAGE = "com.camlait.global.erp";

    public final static String DAO_BASE_PACKAGE = ROOT_PACKAGE + ".dao";
    public final static String DOMAIN_BASE_PACKAGE = ROOT_PACKAGE + ".domain";
    public final static String SERVICE_BASE_PACKAGE = ROOT_PACKAGE + ".delegate";

    public static String RETRIEVE_ALL = "ALL";

    public static String unavailableProductMessage(DocumentDetails ligne) {
        String message = "";
        message = "The product " + ligne.getProduct().getProductDescription() + " is not available." + " Only "
                + ligne.getProduct().availableQuantity(ligne.getDocument().getStore()) + " is available";
        return message;
    }

}
