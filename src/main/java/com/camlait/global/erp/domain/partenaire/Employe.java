package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.auth.Utilisateur;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.operation.Operation;

@Entity
public class Employe extends Partenaire {

    @Column(unique = true, nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String nom;

    private String prenom;

    @Column(name="dateDeNassance")
    private DateTime dateDeNaissance;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "responsable")
    private Collection<Operation> operations;

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

    public DateTime getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(DateTime dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

}
