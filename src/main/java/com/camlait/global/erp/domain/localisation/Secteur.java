package com.camlait.global.erp.domain.localisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.ClePrimaires;

@Entity
public class Secteur extends Localisation {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID)
    private Region region;

    @OneToMany(mappedBy="secteur")
    private Collection<Zone> zones;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Collection<Zone> getZones() {
        return zones;
    }

    public void setZones(Collection<Zone> zones) {
        this.zones = zones;
    }

    public Secteur() {

    }
}
