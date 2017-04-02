package com.camlait.global.erp.domain.enumeration;

public enum OtherEnum implements EnumTypeEntitity {
    INVENTAIRE("INV"),
    BMQ("BMQ"),
    CENTER("C"),
    REGION("R"),
    SECTOR("S"),
    ZONE("Z"),
    LAND_STORE("MM"),
    MOBILE_STORE("MF"),
    WAREHOUSE("EN");
    private final String type;
    
    private OtherEnum(String type) {
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
