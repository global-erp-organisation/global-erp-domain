package com.camlait.global.erp.domain.auth;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.Etat;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class RessourceUtilisateur extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ressourceUtilisateurId;

    @Transient
    private String utilisateId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur utilisateur;

    @Transient
    private Long ressourceId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ressourceId")
    private Ressource ressource;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public RessourceUtilisateur(Utilisateur utilisateur, Ressource ressource, Etat etat) {
        super();
        this.utilisateur = utilisateur;
        this.ressource = ressource;
        this.etat = etat;
    }

    public RessourceUtilisateur() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
    public void setRessourceId(){
        setRessourceId(getRessource().getRessourceId());
    }
    
    public void setUtilisateurId(){
        setUtilisateId(getUtilisateur().getCodeUtilisateur());
    }
}
