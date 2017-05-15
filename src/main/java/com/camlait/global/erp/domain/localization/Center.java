package com.camlait.global.erp.domain.localization;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "`loc-centres`")
public class Center extends Localization {

    @OneToMany(mappedBy = "centre")
    private Collection<Region> regions = Lists.newArrayList();

    public Center() {
        setTypeLocal(OtherEnum.CENTER);
    }

    @Override
    public Center init() {
    	setRegions(regions.stream().map(r->{
    		return r.init();
    	}).collect(Collectors.toList()));
    	return this;
    }
    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.CENTER;
    }
}
