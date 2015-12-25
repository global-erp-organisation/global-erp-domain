package com.camlait.global.erp.domain.operation.reglement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.camlait.global.erp.domain.Entite;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ModeDeReglement extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modeDeReglementId;
    
    @Column(name = "codeModeReglement", nullable = false, unique = true)
    private String codeModeReglement;
    
    private String descriptionModeReglement;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
      
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
    
    public Long getModeDeReglementId() {
        return modeDeReglementId;
    }
    
    public void setModeDeReglementId(Long id) {
        this.modeDeReglementId = id;
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeModeReglement == null) ? 0 : codeModeReglement.hashCode());
        result = prime * result + ((modeDeReglementId == null) ? 0 : modeDeReglementId.hashCode());
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
        } else if (!codeModeReglement.equals(other.codeModeReglement))
            return false;
        if (modeDeReglementId == null) {
            if (other.modeDeReglementId != null)
                return false;
        } else if (!modeDeReglementId.equals(other.modeDeReglementId))
            return false;
        return true;
    }
    
    public ModeDeReglement() {
    
    }
}
