package com.camlait.global.erp.domain.enumeration;

public enum AutreEnum implements EnumTypeEntite {
    INVENTAIRE("INV"),
    BMQ("BMQ"),
    CENTRE("C"),
    REGION("R"),
    SECTEUR("S"),
    ZONE("Z"),
    MAGASIN_MOBILE("MM"),
    MAGASIN_FIXE("MF"),
    ENTREPOT ("EN");
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
