package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.operation.caisse.Caisse;

@Entity
public class Caissier extends Employe {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.CAISSE_ID)
    private Caisse caisse;

    private String motDePasse;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public DateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(DateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public DateTime getDerniereMiseAJour() {
        return derniereMiseAJour;
    }

    public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }

    public Caissier() {

    }
}
