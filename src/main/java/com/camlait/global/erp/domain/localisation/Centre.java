package com.camlait.global.erp.domain.localisation;

import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Centre extends Localisation {

    private Collection<Region> regions;

    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    public Centre() {

    }
}
