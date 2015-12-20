package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.immobilisation.Vehicule;
import com.camlait.global.erp.domain.localisation.Zone;

@Entity
public class Vendeur extends Employe {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID)
    private Zone zoneDeVente;

    @OneToMany(mappedBy = "immobilisation")
    private Collection<Vehicule> vehicules;

    public Zone getZoneDeVente() {
        return zoneDeVente;
    }

    public void setZoneDeVente(Zone zoneDeVente) {
        this.zoneDeVente = zoneDeVente;
    }

    public Collection<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Collection<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

}
