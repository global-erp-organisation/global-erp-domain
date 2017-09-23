package com.camlait.global.erp.domain.config;

import com.camlait.global.erp.domain.document.DocumentDetails;

public class GlobalAppConstants {

    private GlobalAppConstants() {

    }

    /**
     * Root package hierarchy for the whole global erp system.
     */
    public final static String ROOT_PACKAGE = "com.camlait.global.erp";

    /**
     * Data access objects root package name.
     * This has to be used as argument in the ComponentScan or EnableJpaRepository decoration
     * to be able to use DAO objects without explicit instantiation.
     */
    public final static String DAO_BASE_PACKAGE = ROOT_PACKAGE + ".dao";
    /**
     * Domain entity objects root package name.
     * This has to be used as argument in the EntityScan decoration
     * to be able to use Entity objects.
     */
    public final static String DOMAIN_BASE_PACKAGE = ROOT_PACKAGE + ".domain";
    /**
     * Business objects root package name.
     * This has to be used as argument in the ComponentScan decoration
     * to be able to use Business model objects without explicit instantiation.
     */
    public final static String DELEGATE_BASE_PACKAGE = ROOT_PACKAGE + ".delegate";
    /**
     * Service Objects root package name.
     */
    public final static String SERVICE_BASE_PACKAGE = ROOT_PACKAGE + ".service";

    public static String unavailableProductMessage(DocumentDetails ligne) {
        String message = "";
        message = "The product " + ligne.getProduct().getProductDescription() + " is not available." + " Only "
                + ligne.getProduct().availableQuantity(ligne.getDocument().getStore()) + " is available";
        return message;
    }

}
