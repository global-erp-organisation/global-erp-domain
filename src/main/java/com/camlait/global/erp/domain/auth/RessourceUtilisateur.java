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

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.Etat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class RessourceUtilisateur extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ressourceUtilisateurId;

	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;

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

	public RessourceUtilisateur(Long ressourceUtilisateurId, Utilisateur utilisateur, Ressource ressource, Etat etat,
			Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.ressourceUtilisateurId = ressourceUtilisateurId;
		this.utilisateur = utilisateur;
		this.ressource = ressource;
		this.etat = etat;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}
	
}
