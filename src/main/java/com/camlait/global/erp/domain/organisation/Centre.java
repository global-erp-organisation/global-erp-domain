package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Centre extends Localisation {

    @JsonManagedReference
    @OneToMany(mappedBy = "centre", fetch = FetchType.EAGER)
    private Collection<Region> regions = Sets.newHashSet();

    public Centre() {
        setTypeLocal(AutreEnum.CENTRE);
    }
}
