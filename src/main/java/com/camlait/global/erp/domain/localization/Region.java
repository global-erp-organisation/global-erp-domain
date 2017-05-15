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
@Table(name = "`loc-regions`")
public class Region extends Localization {

    @Transient
    private String centreId;

    @ManyToOne
    @JoinColumn(name = "centreId")
    private Center centre;

    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    private Collection<Sector> secteurs = Lists.newArrayList();

    public Region() {
        setTypeLocal(OtherEnum.REGION);
    }

    @Override
    public Region init() {
        setCentreId(centre == null ? null : centre.getLocalId());
        setSecteurs(secteurs == null ? Lists.newArrayList() : secteurs.stream().map(s -> {
            return s.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.REGION;
    }
}
