package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Secteur extends Localisation {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "regionId")
    private Region region;

    @OneToMany(mappedBy="secteur")
    @JsonManagedReference
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
        setTypeLocal(AutreEnum.SECTEUR);
    }
}
