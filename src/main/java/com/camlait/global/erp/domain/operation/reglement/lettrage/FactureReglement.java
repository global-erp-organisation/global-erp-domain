package com.camlait.global.erp.domain.operation.reglement.lettrage;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.vente.FactureClient;
import com.camlait.global.erp.domain.operation.reglement.Reglement;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.pk.PKFactureReglement;

@Entity
public class FactureReglement extends Entite {

    @EmbeddedId
    private PKFactureReglement factureReglementId;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private FactureClient facture;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.REGLEMENT_ID)
    private Reglement reglement;

    private DateTime dateDeVentilation;

    private Employe responsable;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    public PKFactureReglement getFactureReglementId() {
        return factureReglementId;
    }

    public void setFactureReglementId(PKFactureReglement factureReglementId) {
        this.factureReglementId = factureReglementId;
    }

    public FactureClient getFacture() {
        return facture;
    }

    public void setFacture(FactureClient facture) {
        this.facture = facture;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public DateTime getDateDeVentilation() {
        return dateDeVentilation;
    }

    public void setDateDeVentilation(DateTime dateDeVentilation) {
        this.dateDeVentilation = dateDeVentilation;
    }

    public Employe getResponsable() {
        return responsable;
    }

    public void setResponsable(Employe responsable) {
        this.responsable = responsable;
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
        result = prime * result + ((factureReglementId == null) ? 0 : factureReglementId.hashCode());
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
        FactureReglement other = (FactureReglement) obj;
        if (factureReglementId == null) {
            if (other.factureReglementId != null)
                return false;
        }
        else if (!factureReglementId.equals(other.factureReglementId))
            return false;
        return true;
    }

}
