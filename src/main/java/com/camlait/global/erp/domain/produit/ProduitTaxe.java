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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ProduitTaxe extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produitTaxeId;
    
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "taxeId")
    private Taxe taxe;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    public Produit getProduit() {
        return produit;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
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
    
    public Long getProduitTaxeId() {
        return produitTaxeId;
    }
    
    public void setProduitTaxeId(Long produitTaxeId) {
        this.produitTaxeId = produitTaxeId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produitTaxeId == null) ? 0 : produitTaxeId.hashCode());
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
        ProduitTaxe other = (ProduitTaxe) obj;
        if (produitTaxeId == null) {
            if (other.produitTaxeId != null)
                return false;
        } else if (!produitTaxeId.equals(other.produitTaxeId))
            return false;
        return true;
    }
    
    public ProduitTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
