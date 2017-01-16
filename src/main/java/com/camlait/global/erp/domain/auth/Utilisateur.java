package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
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

	@JsonManagedReference
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Employe> employes = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "utilisateur")
	private Collection<RessourceUtilisateur> ressourceUtilisateurs = Sets.newHashSet();

	public Utilisateur() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}	
}
