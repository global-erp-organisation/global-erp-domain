package com.camlait.global.erp.domain.produit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.enumeration.Portee;

@Entity
public class CategorieProduit extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categorieProduitId;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.CATEGORIE_PRODUIT_ID)
    private CategorieProduit categorieParent;

    @Column(unique = true, nullable = false)
    private String codeCategorieProduit;

    private String descriptionCategorie;

    private Portee portee;

    private boolean categorieTaxable;

    public int getCategorieProduitId() {
        return categorieProduitId;
    }

    public void setCategorieProduitId(int categorieProduitId) {
        this.categorieProduitId = categorieProduitId;
    }

    public CategorieProduit getCategorieParent() {
        return categorieParent;
    }

    public void setCategorieParent(CategorieProduit categorieParent) {
        this.categorieParent = categorieParent;
    }

    public String getCodeCategorieProduit() {
        return codeCategorieProduit;
    }

    public void setCodeCategorieProduit(String codeCategorieProduit) {
        this.codeCategorieProduit = codeCategorieProduit;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    public Portee getPortee() {
        return portee;
    }

    public void setPortee(Portee portee) {
        this.portee = portee;
    }

    public boolean isCategorieTaxable() {
        return categorieTaxable;
    }

    public void setCategorieTaxable(boolean categorieTaxable) {
        this.categorieTaxable = categorieTaxable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + categorieProduitId;
        result = prime * result + ((codeCategorieProduit == null) ? 0 : codeCategorieProduit.hashCode());
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
        CategorieProduit other = (CategorieProduit) obj;
        if (categorieProduitId != other.categorieProduitId)
            return false;
        if (codeCategorieProduit == null) {
            if (other.codeCategorieProduit != null)
                return false;
        }
        else if (!codeCategorieProduit.equals(other.codeCategorieProduit))
            return false;
        return true;
    }

    public CategorieProduit() {
        //
    }
}
