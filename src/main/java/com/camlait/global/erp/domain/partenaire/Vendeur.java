package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.immobilisation.Vehicule;
import com.camlait.global.erp.domain.localisation.Zone;

@Entity
public class Vendeur extends Employe {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID)
    private Zone zoneDeVente;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.IMMO_ID)
    private Vehicule vehicule;

    public Zone getZoneDeVente() {
        return zoneDeVente;
    }

    public void setZoneDeVente(Zone zoneDeVente) {
        this.zoneDeVente = zoneDeVente;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
