package com.camlait.global.erp.domain.operation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Operation extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long operationId;
    
    private Date dateOperation;
    
    @Enumerated(EnumType.STRING)
    private SensOperation sensOperation;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    private String libelleOperation;
    
    private double montantOperation;
    
    @ManyToOne
    @JoinColumn(name = "responsableId")
    private Employe responsable;
    
    @ManyToOne
    @JoinColumn(name = "partenaireId")
    private Partenaire partenaire;
    
    
    public Date getDateOperation() {
        return dateOperation;
    }
    
    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
    
    public SensOperation getSensOperation() {
        return sensOperation;
    }
    
    public void setSensOperation(SensOperation sensOperation) {
        this.sensOperation = sensOperation;
    }
    
    public Long getOperationId() {
        return operationId;
    }
    
    public void setOperationId(Long id) {
        this.operationId = id;
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
    
    public Employe getResponsable() {
        return responsable;
    }
    
    public void setResponsable(Employe responsable) {
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
        result = prime * result + ((operationId == null) ? 0 : operationId.hashCode());
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
        if (operationId == null) {
            if (other.operationId != null)
                return false;
        } else if (!operationId.equals(other.operationId))
            return false;
        return true;
    }
    
    public Operation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
    }
}
