package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Centre extends Localisation {

    @OneToMany(mappedBy = "centre",fetch=FetchType.EAGER)
    private Collection<Region> regions;

    public Centre() {
        setTypeLocal(AutreEnum.CENTRE);
    }
}
