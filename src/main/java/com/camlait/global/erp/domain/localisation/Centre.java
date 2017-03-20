package com.camlait.global.erp.domain.localisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`loc-centres`")
public class Centre extends Localisation {

    @JsonManagedReference
    @OneToMany(mappedBy = "centre")
    private Collection<Region> regions = Sets.newHashSet();

    public Centre() {
        setTypeLocal(OtherEnum.CENTRE);
    }
}
