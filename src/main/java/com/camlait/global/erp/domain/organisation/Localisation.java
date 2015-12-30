package com.camlait.global.erp.domain.organisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Localisation extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long localId;
    
    @Column(nullable = false, unique = true)
    private String code;
    
    private String descriptionLocal;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    @Enumerated(EnumType.STRING)
    private AutreEnum typeLocal;
    
    public Long getLocalId() {
        return localId;
    }
    
    public void setLocalId(Long localId) {
        this.localId = localId;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescriptionLocal() {
        return descriptionLocal;
    }
    
    public void setDescriptionLocal(String descriptionLocal) {
        this.descriptionLocal = descriptionLocal;
    }
    
    public AutreEnum getTypeLocal() {
        return typeLocal;
    }
    
    public void setTypeLocal(AutreEnum typeLocal) {
        this.typeLocal = typeLocal;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((localId == null) ? 0 : localId.hashCode());
        return result;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Localisation other = (Localisation) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (localId == null) {
            if (other.localId != null)
                return false;
        } else if (!localId.equals(other.localId))
            return false;
        return true;
    }
    
    public Localisation() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
