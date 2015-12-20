package com.camlait.global.erp.domain.entrepot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.localisation.Centre;

@Entity
public class Entrepot extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entrepotId;

    @Column(nullable = false, unique = true)
    private String codeEntrepot;

    private String descriptionEntrepot;

    private Centre centre;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    public int getEntrepotId() {
        return entrepotId;
    }

    public void setEntrepotId(int entrepotId) {
        this.entrepotId = entrepotId;
    }

    public String getCodeEntrepot() {
        return codeEntrepot;
    }

    public void setCodeEntrepot(String codeEntrepot) {
        this.codeEntrepot = codeEntrepot;
    }

    public String getDescriptionEntrepot() {
        return descriptionEntrepot;
    }

    public void setDescriptionEntrepot(String descriptionEntrepot) {
        this.descriptionEntrepot = descriptionEntrepot;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
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
        result = prime * result + ((codeEntrepot == null) ? 0 : codeEntrepot.hashCode());
        result = prime * result + entrepotId;
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
        Entrepot other = (Entrepot) obj;
        if (codeEntrepot == null) {
            if (other.codeEntrepot != null)
                return false;
        }
        else if (!codeEntrepot.equals(other.codeEntrepot))
            return false;
        if (entrepotId != other.entrepotId)
            return false;
        return true;
    }

    public Entrepot() {

    }
}
