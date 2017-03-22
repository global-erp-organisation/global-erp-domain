package com.camlait.global.erp.domain.enumeration;

public enum Sex implements EnumTypeEntitity {
    
    MALE("M"),
    FEMALE("F");
    
    private final String type;
    
    private Sex(String type) {
        this.type = type;
    }
    
    @Override
    public EnumTypeEntitity getEnumType() {
        return this;
    }
    
    @Override
    public String getType() {
        return this.type;
    }
}
