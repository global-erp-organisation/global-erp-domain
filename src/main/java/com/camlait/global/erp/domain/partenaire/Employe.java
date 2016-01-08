package com.camlait.global.erp.domain.partenaire;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.camlait.global.erp.domain.auth.Utilisateur;
import com.camlait.global.erp.domain.enumeration.Sexe;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Employe extends Partenaire {
    
    @Column(unique = true, nullable = false)
    private String matricule;
    
    @Column(nullable = false)
    private String nom;
    
    private String prenom;
    
    private Date dateDeNaissance;
    
    @OneToOne
    @JoinColumn(name = "codeUtilisateur")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "emploisId")
    private Emplois emplois;
    
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    
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
    
    public Sexe getSexe() {
        return sexe;
    }
    
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    
    @Override
    public String toString() {
        return "[" + matricule + "] " + prenom + " " + nom+""+sexe.getType()+" "+emplois.getDescriptionEmplois();
    }
    
    public Employe() {
        setTypePartenaire(TypePartenaire.EMPLOYE);
    }
}
