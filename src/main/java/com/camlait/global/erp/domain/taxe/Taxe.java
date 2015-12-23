package com.camlait.global.erp.domain.taxe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Taxe extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "codeTaxe", unique = true, nullable = false)
    private String codeTaxe;
    
    private String taxeDescription;
    
    private double valeurPourcentage;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    public Long getTaxeId() {
        return id;
    }
    
    public void setTaxeId(Long taxeId) {
        this.id = taxeId;
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
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public Taxe(Long taxeId, String codeTaxe) {
        super();
        this.id = taxeId;
        this.codeTaxe = codeTaxe;
    }
    
    public Taxe() {
    }
}
