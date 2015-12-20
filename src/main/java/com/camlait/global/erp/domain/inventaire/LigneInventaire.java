package com.camlait.global.erp.domain.inventaire;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.pk.PKLigneInventaire;
import com.camlait.global.erp.domain.produit.Produit;

@Entity
public class LigneInventaire extends Entite {

    @EmbeddedId
    private PKLigneInventaire ligneInventaireId;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.INVENTAIRE_ID)
    private Inventaire inventaire;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PRODUIT_ID)
    private Produit produit;

    private int quantiteReelle;

    private int quantiteAjustee;

    private double prixUnitaireReelle;

    private double prixUnitaireAjustee;

    public PKLigneInventaire getLigneInventaireId() {
        return ligneInventaireId;
    }

    public void setLigneInventaireId(PKLigneInventaire ligneInventaireId) {
        this.ligneInventaireId = ligneInventaireId;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantiteReelle() {
        return quantiteReelle;
    }

    public void setQuantiteReelle(int quantiteReelle) {
        this.quantiteReelle = quantiteReelle;
    }

    public int getQuantiteAjustee() {
        return quantiteAjustee;
    }

    public void setQuantiteAjustee(int quantiteAjustee) {
        this.quantiteAjustee = quantiteAjustee;
    }

    public double getPrixUnitaireReelle() {
        return prixUnitaireReelle;
    }

    public void setPrixUnitaireReelle(double prixUnitaireReelle) {
        this.prixUnitaireReelle = prixUnitaireReelle;
    }

    public double getPrixUnitaireAjustee() {
        return prixUnitaireAjustee;
    }

    public void setPrixUnitaireAjustee(double prixUnitaireAjustee) {
        this.prixUnitaireAjustee = prixUnitaireAjustee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ligneInventaireId == null) ? 0 : ligneInventaireId.hashCode());
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
        LigneInventaire other = (LigneInventaire) obj;
        if (ligneInventaireId == null) {
            if (other.ligneInventaireId != null)
                return false;
        }
        else if (!ligneInventaireId.equals(other.ligneInventaireId))
            return false;
        return true;
    }

    public LigneInventaire() {

    }

}
