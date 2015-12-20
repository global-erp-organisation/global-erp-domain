package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ModeDeReglement extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modeReglementId;

    @Column(nullable = false, unique = true)
    private String codeModeReglement;

    private String descriptionModeReglement;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    public int getModeReglementId() {
        return modeReglementId;
    }

    public void setModeReglementId(int modeReglementId) {
        this.modeReglementId = modeReglementId;
    }

    public String getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(String codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
    }

    public String getDescriptionModeReglement() {
        return descriptionModeReglement;
    }

    public void setDescriptionModeReglement(String descriptionModeReglement) {
        this.descriptionModeReglement = descriptionModeReglement;
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
        result = prime * result + ((codeModeReglement == null) ? 0 : codeModeReglement.hashCode());
        result = prime * result + modeReglementId;
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
        ModeDeReglement other = (ModeDeReglement) obj;
        if (codeModeReglement == null) {
            if (other.codeModeReglement != null)
                return false;
        }
        else if (!codeModeReglement.equals(other.codeModeReglement))
            return false;
        if (modeReglementId != other.modeReglementId)
            return false;
        return true;
    }

    public ModeDeReglement() {

    }
}
