package com.camlait.global.erp.domain.partenaire;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.camlait.global.erp.domain.auth.Utilisateur;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employe extends Partenaire {
    
    @Column(unique = true, nullable = false)
    private String matricule;
    
    @Column(nullable = false)
    private String nom;
    
    private String prenom;
    
    private Date dateDeNaissance;
    
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "codeUtilisateur")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "emploisId")
    @JsonBackReference
    private Emplois emplois;
    
    public String getMatricule() {
        return matricule;
    }
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Emplois getEmplois() {
        return emplois;
    }
    
    public void setEmplois(Emplois emplois) {
        this.emplois = emplois;
    }
    
    @Override
    public String toString() {
        return "[" + matricule + "] " + prenom + " " + nom;
    }
    
    public Employe() {
        setTypePartenaire(TypePartenaire.EMPLOYE);
    }
}
