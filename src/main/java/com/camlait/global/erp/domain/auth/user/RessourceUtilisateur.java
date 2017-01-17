package com.camlait.global.erp.domain.auth.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.Etat;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class RessourceUtilisateur extends Entite {

	@Id
	private String ressourceUtilisateurId;

	@Transient
	private String utilisateurId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;

	@Transient
	private String ressourceId;

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

	@PrePersist
	private void setKey() {
		setRessourceUtilisateurId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
		setRessourceId(ressource.getRessourceId());
		setUtilisateurId(utilisateur.getUtilisateurId());
	}
}