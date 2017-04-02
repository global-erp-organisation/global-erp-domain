package com.camlait.global.erp.domain.enumeration;

public enum PartnerType implements EnumTypeEntitity {
    CLIENT("CL"),
    SELLER("VE"),
    EMPLOYEE("EM"),
    CASHIER("CA"),
    CASH_CLIENT("CC"),
    STORE_OPERATOR("MA"),
    MARGIN_CLIENT("CM");
    
    private final String type;
    
    private PartnerType(String type) {
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
