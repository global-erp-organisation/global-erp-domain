package com.camlait.global.erp.domain.entrepot;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
public class Magasin extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long magasinId;
    
    @Column(name = "codeMagasin", unique = true, nullable = false)
    private String codeMagasin;
    
    private String descriptionMagasin;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "entrepotId")
    private Entrepot entrepot;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    @Enumerated(EnumType.STRING)
    private AutreEnum typeMagasin;
    
    public String getCodeMagasin() {
        return codeMagasin;
    }
    
    public void setCodeMagasin(String codeMagasin) {
        this.codeMagasin = codeMagasin;
    }
    
    public String getDescriptionMagasin() {
        return descriptionMagasin;
    }
    
    public void setDescriptionMagasin(String descriptionMagasin) {
        this.descriptionMagasin = descriptionMagasin;
    }
    
    public Entrepot getEntrepot() {
        return entrepot;
    }
    
    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }
    
    public Long getMagasinId() {
        return magasinId;
    }
    
    public void setMagasinId(Long magasinId) {
        this.magasinId = magasinId;
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
    
    public AutreEnum getTypeMagasin() {
        return typeMagasin;
    }
    
    public void setTypeMagasin(AutreEnum typeMagasin) {
        this.typeMagasin = typeMagasin;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeMagasin == null) ? 0 : codeMagasin.hashCode());
        result = prime * result + ((magasinId == null) ? 0 : magasinId.hashCode());
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
        Magasin other = (Magasin) obj;
        if (codeMagasin == null) {
            if (other.codeMagasin != null)
                return false;
        } else if (!codeMagasin.equals(other.codeMagasin))
            return false;
        if (magasinId == null) {
            if (other.magasinId != null)
                return false;
        } else if (!magasinId.equals(other.magasinId))
            return false;
        return true;
    }
    
    public Magasin() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
