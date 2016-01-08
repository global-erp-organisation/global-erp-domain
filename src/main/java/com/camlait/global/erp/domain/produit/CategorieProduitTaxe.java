package com.camlait.global.erp.domain.produit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class CategorieProduitTaxe extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categorieProduitTaxeId;
    
    @ManyToOne
    @JoinColumn(name = "categorieProduitId")
    private CategorieProduit categorie;
    
    @ManyToOne
    @JoinColumn(name = "taxeId")
    private Taxe taxe;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    public Long getCategorieProduitTaxeId() {
        return categorieProduitTaxeId;
    }
    
    public void setCategorieProduitTaxeId(Long categorieProduitTaxeId) {
        this.categorieProduitTaxeId = categorieProduitTaxeId;
    }
    
    public CategorieProduit getCategorie() {
        return categorie;
    }
    
    public void setCategorie(CategorieProduit categorie) {
        this.categorie = categorie;
    }
    
    public Taxe getTaxe() {
        return taxe;
    }
    
    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
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
        result = prime * result + ((categorieProduitTaxeId == null) ? 0 : categorieProduitTaxeId.hashCode());
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
        CategorieProduitTaxe other = (CategorieProduitTaxe) obj;
        if (categorieProduitTaxeId == null) {
            if (other.categorieProduitTaxeId != null)
                return false;
        } else if (!categorieProduitTaxeId.equals(other.categorieProduitTaxeId))
            return false;
        return true;
    }
    
    public CategorieProduitTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
}
