package com.camlait.global.erp.domain.enumeration;

public enum Sex implements EnumTypeEntite {
    
    MALE("M"),
    FEMALE("F");
    
    private final String type;
    
    private Sex(String type) {
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
