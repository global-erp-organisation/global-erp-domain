package com.camlait.global.erp.domain.localization;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`loc-sectors`")
public class Sector extends Localization {

    @Transient
    private String regionId;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    @OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
    private Collection<Zone> zones = Lists.newArrayList();

    public Sector() {
        setTypeLocal(OtherEnum.SECTOR);
    }

    @Override
    public Sector init() {
        setRegionId(region == null ? null : region.getLocalId());
        setZones(zones == null ? Lists.newArrayList() : zones.stream().map(z -> {
            return z.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.SECTOR;
    }
}
