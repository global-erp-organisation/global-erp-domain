package com.camlait.global.erp.domain.document;

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

@Entity
public class LigneDeDocumentTaxe extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ligneDeDocumentTaxeId;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ligneDeDocumentId")
    private LigneDeDocument ligneDeDocument;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "taxeId")
    private Taxe taxe;
    
    private double tauxDeTaxe;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    public LigneDeDocument getLigneDeDocument() {
        return ligneDeDocument;
    }
    
    public void setLigneDeDocument(LigneDeDocument ligneDeDocument) {
        this.ligneDeDocument = ligneDeDocument;
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
    
    public Long getLigneDeDocumentTaxeId() {
        return ligneDeDocumentTaxeId;
    }
    
    public void setLigneDeDocumentTaxeId(Long ligneDeDocumentTaxeId) {
        this.ligneDeDocumentTaxeId = ligneDeDocumentTaxeId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ligneDeDocumentTaxeId == null) ? 0 : ligneDeDocumentTaxeId.hashCode());
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
        LigneDeDocumentTaxe other = (LigneDeDocumentTaxe) obj;
        if (ligneDeDocumentTaxeId == null) {
            if (other.ligneDeDocumentTaxeId != null)
                return false;
        } else if (!ligneDeDocumentTaxeId.equals(other.ligneDeDocumentTaxeId))
            return false;
        return true;
    }

    public LigneDeDocumentTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
}
