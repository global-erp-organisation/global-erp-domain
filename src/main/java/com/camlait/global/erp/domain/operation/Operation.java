package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.partenaire.Partenaire;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int operationId;

    private DateTime dateOperation;

    private SensOperation sensOperation;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    private String libelleOperation;

    private double montantOperation;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Partenaire responsable;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Partenaire partenaire;

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public DateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(DateTime dateOperation) {
        this.dateOperation = dateOperation;
    }

    public SensOperation getSensOperation() {
        return sensOperation;
    }

    public void setSensOperation(SensOperation sensOperation) {
        this.sensOperation = sensOperation;
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

    public String getLibelleOperation() {
        return libelleOperation;
    }

    public void setLibelleOperation(String libelleOperation) {
        this.libelleOperation = libelleOperation;
    }

    public double getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(double montantOperation) {
        this.montantOperation = montantOperation;
    }

    public Partenaire getResponsable() {
        return responsable;
    }

    public void setResponsable(Partenaire responsable) {
        this.responsable = responsable;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + operationId;
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
        Operation other = (Operation) obj;
        if (operationId != other.operationId)
            return false;
        return true;
    }

    public Operation() {

    }
}
