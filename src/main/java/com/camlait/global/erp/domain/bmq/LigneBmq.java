package com.camlait.global.erp.domain.bmq;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.pk.PKLigneBmq;
import com.camlait.global.erp.domain.produit.Produit;

public class LigneBmq extends Entite {

    @EmbeddedId
    private PKLigneBmq ligneBmqId;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PRODUIT_ID)
    private Produit produit;

    private int quantiteLigne;

    private double prixUnitaireLigne;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.BMQ_ID)
    private Bmq bmq;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.DOCUMENT_ID)
    private Document document;

    public PKLigneBmq getLigneBmqId() {
        return ligneBmqId;
    }

    public void setLigneBmqId(PKLigneBmq ligneBmqId) {
        this.ligneBmqId = ligneBmqId;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantiteLigne() {
        return quantiteLigne;
    }

    public void setQuantiteLigne(int quantiteLigne) {
        this.quantiteLigne = quantiteLigne;
    }

    public double getPrixUnitaireLigne() {
        return prixUnitaireLigne;
    }

    public void setPrixUnitaireLigne(double prixUnitaireLigne) {
        this.prixUnitaireLigne = prixUnitaireLigne;
    }

    public Bmq getBmq() {
        return bmq;
    }

    public void setBmq(Bmq bmq) {
        this.bmq = bmq;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ligneBmqId == null) ? 0 : ligneBmqId.hashCode());
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
        LigneBmq other = (LigneBmq) obj;
        if (ligneBmqId == null) {
            if (other.ligneBmqId != null)
                return false;
        }
        else if (!ligneBmqId.equals(other.ligneBmqId))
            return false;
        return true;
    }

    public LigneBmq() {

    }

}
