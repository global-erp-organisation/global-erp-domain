package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;
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

	@OneToMany(mappedBy = "utilisateur")
	private Collection<RessourceUtilisateur> ressourceUtilisateurs;

	public Utilisateur() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Utilisateur(String codeUtilisateur, String courriel, String motDePasse, Date dateDeCreation,
			Date derniereMiseAJour, Collection<Employe> employes,
			Collection<RessourceUtilisateur> ressourceUtilisateurs) {
		super();
		this.codeUtilisateur = codeUtilisateur;
		this.courriel = courriel;
		this.motDePasse = motDePasse;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.employes = employes;
		this.ressourceUtilisateurs = ressourceUtilisateurs;
	}
	
}
