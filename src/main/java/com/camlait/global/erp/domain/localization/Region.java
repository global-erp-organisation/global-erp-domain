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
@Table(name = "`loc-regions`")
public class Region extends Localization {

    @Transient
    private String centreId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "centreId")
    private Center centre;

    @JsonManagedReference
    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    private Collection<Sector> secteurs = Lists.newArrayList();

    public Region() {
        setTypeLocal(OtherEnum.REGION);
    }

    @Override
    public void postConstructOperation() {
        setCentreId(centre.getLocalId());
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.REGION;
    }
}
