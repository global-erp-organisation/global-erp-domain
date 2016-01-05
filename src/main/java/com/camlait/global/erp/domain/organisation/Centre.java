package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
public class Centre extends Localisation {

    @OneToMany(mappedBy = "centre", fetch=FetchType.LAZY)
    private Collection<Region> regions;

    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    public Centre() {
        setTypeLocal(AutreEnum.CENTRE);
    }
}
