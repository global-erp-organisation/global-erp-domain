package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Emplois extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emploisId;
    
    @Column(unique = true, nullable = false)
    private String codeEmplois;
    private String descriptionEmplois;
    
    @OneToMany(mappedBy = "emplois")
    private Collection<Employe> employes;
    
    public Long getEmploisId() {
        return emploisId;
    }
    
    public void setEmploisId(Long emploisId) {
        this.emploisId = emploisId;
    }
    
    public String getCodeEmplois() {
        return codeEmplois;
    }
    
    public void setCodeEmplois(String codeEmplois) {
        this.codeEmplois = codeEmplois;
    }
    
    public String getDescriptionEmplois() {
        return descriptionEmplois;
    }
    
    public void setDescriptionEmplois(String descriptionEmplois) {
        this.descriptionEmplois = descriptionEmplois;
    }
    
    public Collection<Employe> getEmployes() {
        return employes;
    }
    
    public void setEmployes(Collection<Employe> employes) {
        this.employes = employes;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emploisId == null) ? 0 : emploisId.hashCode());
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
        Emplois other = (Emplois) obj;
        if (emploisId == null) {
            if (other.emploisId != null)
                return false;
        } else if (!emploisId.equals(other.emploisId))
            return false;
        return true;
    }
    
    public Emplois() {
        super();
    }
    
}
