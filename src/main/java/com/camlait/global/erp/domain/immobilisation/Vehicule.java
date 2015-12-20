package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vehicule extends Immobilisation {

    @Column(unique = true, nullable = false)
    private String immatriculation;
    private String marque;
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public Vehicule(){
        
    }
}
