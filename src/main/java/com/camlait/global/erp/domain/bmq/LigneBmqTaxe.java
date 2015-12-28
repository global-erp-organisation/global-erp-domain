package com.camlait.global.erp.domain.bmq;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;

@Entity
public class LigneBmqTaxe extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ligneBmqTaxeId;
    
    @ManyToOne
    @JoinColumn(name = "ligneBmqId")
    private LigneBmq ligneBmq;
    
    @ManyToOne
    @JoinColumn(name = "taxeId")
    private Taxe taxe;
    
    private double tauxDeTaxe;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    public Long getLigneBmqTaxeId() {
        return ligneBmqTaxeId;
    }
    
    public void setLigneBmqTaxeId(Long ligneBmqTaxeId) {
        this.ligneBmqTaxeId = ligneBmqTaxeId;
    }
    
    public LigneBmq getLigneBmq() {
        return ligneBmq;
    }
    
    public void setLigneBmq(LigneBmq ligneBmq) {
        this.ligneBmq = ligneBmq;
    }
    
    public Taxe getTaxe() {
        return taxe;
    }
    
    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }
    
    public double getTauxDeTaxe() {
        return tauxDeTaxe;
    }
    
    public void setTauxDeTaxe(double tauxDeTaxe) {
        this.tauxDeTaxe = tauxDeTaxe;
    }
    
    public Date getDateDeCreation() {
        return dateDeCreation;
    }
    
    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
    
    public Date getDerniereMiseAJour() {
        return derniereMiseAJour;
    }
    
    public void setDerniereMiseAJour(Date derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ligneBmqTaxeId == null) ? 0 : ligneBmqTaxeId.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LigneBmqTaxe other = (LigneBmqTaxe) obj;
        if (ligneBmqTaxeId == null) {
            if (other.ligneBmqTaxeId != null)
                return false;
        } else if (!ligneBmqTaxeId.equals(other.ligneBmqTaxeId))
            return false;
        return true;
    }
    
    public LigneBmqTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
