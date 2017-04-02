package com.camlait.global.erp.domain.partner;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.operation.cash.Cash;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`partner-cahsiers`")
@EqualsAndHashCode(callSuper = true)
public class Cashier extends Employee {

    @Transient
    private String cashId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cashId", updatable = false, insertable = false)
    private Cash cash;

    private String motDePasse;

    public Cashier() {
        setPartnerType(PartnerType.CASHIER);
    }

    @Override
    public void postConstructOperation() {
        setCenterId(getCentre().getLocalId());
        setPartnerGroupId(getPartnerGroup().getPartnerGroupId());
        setTarifId(getTarif().getTarifId());
        setCashId(cash.getCashId());
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return PartnerType.CASHIER;
    }


}
