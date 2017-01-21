package com.camlait.global.erp.domain.auth.user;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = { "employes", "ressourceUtilisateurs" })
@ToString(exclude = { "employes", "ressourceUtilisateurs" })
@Builder
public class Utilisateur extends Entite {
	@Id
	private String utilisateurId;

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

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Groupe> groupes = Sets.newHashSet();

	public Utilisateur() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@Override
	public void postConstructOperation() {
		ressourceGroupCopy();
	}

	private void ressourceGroupCopy() {
		if (groupes != null && !groupes.isEmpty()) {
			groupes.stream().forEach(g -> {
				Collection<RessourceUtilisateur> ru = g.getRessourceGroupes().stream().map(rg -> {
					return RessourceUtilisateur.builder().dateDeCreation(new Date()).derniereMiseAJour(new Date())
							.etat(rg.getEtat()).ressource(rg.getRessource()).ressourceId(rg.getRessourceId())
							.utilisateur(this).utilisateurId(this.getUtilisateurId()).build();

				}).collect(Collectors.toList());
				ressourceUtilisateurs.addAll(ru);
			});
		}
	}
}
