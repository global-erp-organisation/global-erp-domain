package com.camlait.global.erp.domain.partner;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.localization.Zone;
import com.camlait.global.erp.domain.operation.missing.FinancialMissingOperation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-sellers`")
public class Seller extends Employee {

    @Transient
    private String zoneId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone saleZone;

    @JsonManagedReference
    @OneToMany(mappedBy = "seller")
    private Collection<FinancialMissingOperation> financialMissings = Lists.newArrayList();

    private boolean commissionable;

    private double commissionRate;

    public Seller() {
        setPartnerType(PartnerType.SELLER);
    }

    @Override
    public void postConstructOperation() {
        setCenterId(getCentre().getLocalId());
        setPartnerGroupId(getPartnerGroup().getPartnerGroupId());
        setTarifId(getTarif().getTarifId());
        setProfessionId(getProfession().getProfessionId());
        setUserId(getUser() != null ? getUser().getUserId() : null);
        setZoneId(saleZone.getLocalId());
    }
}
