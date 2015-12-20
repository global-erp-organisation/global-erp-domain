package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Entity;

@Entity
public class Refrigerateur extends Immobilisation {

    private String numeroDeSerie;
    private String marque;
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public Refrigerateur(){
        
    }
}
