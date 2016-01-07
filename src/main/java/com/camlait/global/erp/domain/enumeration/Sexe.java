package com.camlait.global.erp.domain.enumeration;

public enum Sexe implements EnumTypeEntite {
    
    HOMME("H"),
    FEMME("F");
    
    private final String type;
    
    private Sexe(String type) {
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
