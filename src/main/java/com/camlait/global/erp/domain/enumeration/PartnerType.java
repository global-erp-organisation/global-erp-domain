package com.camlait.global.erp.domain.enumeration;

public enum PartnerType implements EnumTypeEntite {
    CLIENT("CL"),
    VENDEUR("VE"),
    EMPLOYE("EM"),
    CAISSIER("CA"),
    CLIENT_COMPTANT("CC"),
    MAGASINIER("MA"),
    CLIENT_A_MARGE("CM");
    
    private final String type;
    
    private PartnerType(String type) {
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
