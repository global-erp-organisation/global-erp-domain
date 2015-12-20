package com.camlait.global.erp.domain.localisation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.ClePrimaires;

@Entity
public class Zone extends Localisation {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID)
    private Secteur secteur;

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    
    public Zone(){
        
    }
}
