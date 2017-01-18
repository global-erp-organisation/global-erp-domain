package com.camlait.global.erp.domain.auth.user;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Groupe extends Entite {

	@Id
	private String groupeId;

	private String descriptionGroupe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@JsonManagedReference
	@OneToMany(mappedBy = "groupe")
	private Collection<GroupeUtilisateur> groupeUtilisateurs = Sets.newHashSet();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "groupe")
	private Collection<RessourceGroupe> ressourceGroupes = Sets.newHashSet();

	
	@JsonManagedReference
	@ManyToMany(mappedBy = "groupes", cascade = CascadeType.ALL)
	@JoinTable(name = "groupe_utilisateur", 
	joinColumns = @JoinColumn(name = "groupeId", referencedColumnName = "utilisateurId"), 
	inverseJoinColumns = @JoinColumn(name = "utilisateurId", referencedColumnName = "groupeId"))
	private Collection<Utilisateur> utilisateurs = Sets.newHashSet();

	public Groupe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PrePersist
	private void setKey() {
		setGroupeId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
	}
}
