package com.camlait.global.erp.domain.taxe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Taxe extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taxeId;

    @Column(unique = true, nullable = false)
    private String codeTaxe;

    private String taxeDescription;

    private double valeurPourcentage;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    public int getTaxeId() {
        return taxeId;
    }

    public void setTaxeId(int taxeId) {
        this.taxeId = taxeId;
    }

    public String getCodeTaxe() {
        return codeTaxe;
    }

    public void setCodeTaxe(String codeTaxe) {
        this.codeTaxe = codeTaxe;
    }

    public String getTaxeDescription() {
        return taxeDescription;
    }

    public void setTaxeDescription(String taxeDescription) {
        this.taxeDescription = taxeDescription;
    }

    public double getValeurPourcentage() {
        return valeurPourcentage;
    }

    public void setValeurPourcentage(double valeurPourcentage) {
        this.valeurPourcentage = valeurPourcentage;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + taxeId;
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
        Taxe other = (Taxe) obj;
        if (taxeId != other.taxeId)
            return false;
        return true;
    }

    public Taxe() {
    }
}
