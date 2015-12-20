package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.vente.FactureClient;
import com.camlait.global.erp.domain.immobilisation.Refrigerateur;
import com.camlait.global.erp.domain.localisation.Zone;

@Entity
public class Client extends Partenaire {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID)
    private Zone zone;

    @OneToMany(mappedBy = "client")
    private Collection<FactureClient> factures;

    @OneToMany(mappedBy = "immobilisation")
    private Collection<Refrigerateur> refrigerateurs;

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Collection<Refrigerateur> getRefrigerateurs() {
        return refrigerateurs;
    }

    public void setRefrigerateurs(Collection<Refrigerateur> refrigerateurs) {
        this.refrigerateurs = refrigerateurs;
    }

    public Collection<FactureClient> getFactures() {
        return factures;
    }

    public void setFactures(Collection<FactureClient> factures) {
        this.factures = factures;
    }

}
