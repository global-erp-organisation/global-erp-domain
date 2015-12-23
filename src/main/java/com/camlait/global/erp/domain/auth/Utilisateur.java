package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
public class Utilisateur extends Entite {
    
    @Id
    private String codeUtilisateur;
    
    @Column(nullable = false)
    private String courriel;
    
    private String motDePasse;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Employe> employes;
    
    public String getCodeUtilisateur() {
        return codeUtilisateur;
    }
    
    public void setCodeUtilisateur(String codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }
    
    public String getCourriel() {
        return courriel;
    }
    
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }
    
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
        result = prime * result + ((codeUtilisateur == null) ? 0 : codeUtilisateur.hashCode());
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
        Utilisateur other = (Utilisateur) obj;
        if (codeUtilisateur == null) {
            if (other.codeUtilisateur != null)
                return false;
        } else if (!codeUtilisateur.equals(other.codeUtilisateur))
            return false;
        return true;
    }
    
    public Utilisateur() {
    
    }
}
