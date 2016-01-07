package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Produit extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produitId;
    
    @Column(name = "codeProduit", unique = true, nullable = false)
    private String codeProduit;
    
    private String descriptionProduit;
    
    private double prixUnitaireProduit;
    
    private double prixUnitaireMarge;
    
    @ManyToOne
    @JoinColumn(name = "categorieProduitId")
    private CategorieProduit categorie;
    
    private boolean produitTaxable;
    
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private Collection<ProduitTaxe> produitTaxes;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    private boolean suiviEnStock;
    
    public String getCodeProduit() {
        return codeProduit;
    }
    
    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }
    
    public String getDescriptionProduit() {
        return descriptionProduit;
    }
    
    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }
    
    public double getPrixUnitaireProduit() {
        return prixUnitaireProduit;
    }
    
    public void setPrixUnitaireProduit(double prixUnitaireProduit) {
        this.prixUnitaireProduit = prixUnitaireProduit;
    }
    
    public CategorieProduit getCategorie() {
        return categorie;
    }
    
    public void setCategorie(CategorieProduit categorie) {
        this.categorie = categorie;
        copieCategorieProduitTaxe();
    }
    
    public boolean isProduitTaxable() {
        return produitTaxable;
    }
    
    public void setProduitTaxable(boolean produitTaxable) {
        this.produitTaxable = produitTaxable;
    }
    
    public Long getProduitId() {
        return produitId;
    }
    
    public void setProduitId(Long produitId) {
        this.produitId = produitId;
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
    
    public Collection<ProduitTaxe> getProduitTaxes() {
        return produitTaxes;
    }
    
    public void setProduitTaxes(Collection<ProduitTaxe> produitTaxes) {
        this.produitTaxes = produitTaxes;
    }
    
    public double getPrixUnitaireMarge() {
        return prixUnitaireMarge;
    }
    
    public void setPrixUnitaireMarge(double prixUnitaireMarge) {
        this.prixUnitaireMarge = prixUnitaireMarge;
    }
    
    public boolean isSuiviEnStock() {
        return suiviEnStock;
    }
    
    public void setSuiviEnStock(boolean suiviEnStock) {
        this.suiviEnStock = suiviEnStock;
    }
    
    @Override
    public String toString() {
        return "[" + codeProduit + "] " + descriptionProduit+" [pu]="+prixUnitaireProduit+" [pm]="+prixUnitaireMarge;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
        result = prime * result + ((codeProduit == null) ? 0 : codeProduit.hashCode());
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
        Produit other = (Produit) obj;
        if (categorie == null) {
            if (other.categorie != null)
                return false;
        } else if (!categorie.equals(other.categorie))
            return false;
        if (codeProduit == null) {
            if (other.codeProduit != null)
                return false;
        } else if (!codeProduit.equals(other.codeProduit))
            return false;
        return true;
    }
    
    public Produit() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
    private void copieCategorieProduitTaxe() {
        final Collection<ProduitTaxe> taxes = new HashSet<>();
        if (categorie != null) {
            final Collection<CategorieProduitTaxe> ctaxes = categorie.getCategorieProduitTaxes();
            if ((ctaxes != null) && (!ctaxes.isEmpty())) {
                ctaxes.stream().forEach(c -> {
                    ProduitTaxe pt = new ProduitTaxe();
                    pt.setProduit(this);
                    pt.setTaxe(c.getTaxe());
                    taxes.add(pt);
                });
                setProduitTaxes(taxes);
            }
        }
    }
}
