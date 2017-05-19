package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.localization.Zone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-clients`")
public class Client extends Partner {

    @Transient
    private String zoneId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

    @OneToMany(mappedBy = "client")
    private Collection<SaleDocument> saleDocuments = Lists.newArrayList();

    private String description;

    private boolean clientAristourne;

    private double ristourne;

    public Client() {
        setPartnerType(PartnerType.CLIENT);
    }

    @Override
    public Client init() {
        setCenterId(getCentre() == null ? null : getCentre().getLocalId());
        setPartnerGroupId(getPartnerGroup() == null ? null : getPartnerGroup().getPartnerGroupId());
        setTarifId(getTarif() == null ? null : getTarif().getTarifId());
        setZoneId(zone == null ? null : zone.getLocalId());
        setSaleDocuments(saleDocuments == null ? Lists.newArrayList() : saleDocuments.stream().map(sd -> {
            return sd.init();
        }).collect(Collectors.toList()));
        return this;
    }

    public Boolean isMarginClient() {
        return this instanceof MarginClient;
    }

    public Boolean isCashSalesClient() {
        return this instanceof CashClient;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return PartnerType.CLIENT;
    }
}
