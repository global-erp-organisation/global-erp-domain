package com.camlait.global.erp.domain.partner;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-cash-clients`")
public class CashClient extends Client {

    public CashClient() {
        setPartnerType(PartnerType.CASH_CLIENT);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return PartnerType.CASH_CLIENT;
    }
}
