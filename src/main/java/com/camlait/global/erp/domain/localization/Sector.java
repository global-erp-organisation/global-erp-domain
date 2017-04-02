package com.camlait.global.erp.domain.localization;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
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
@Table(name = "`loc-sectors`")
public class Sector extends Localization {

    @Transient
    private String regionId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    @JsonManagedReference
    @OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
    private Collection<Zone> zones = Lists.newArrayList();

    public Sector() {
        setTypeLocal(OtherEnum.SECTOR);
    }

    @Override
    public void postConstructOperation() {
        setRegionId(region.getLocalId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.SECTOR;
    }
}
