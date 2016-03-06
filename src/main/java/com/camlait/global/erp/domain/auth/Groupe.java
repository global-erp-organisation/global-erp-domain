package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
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
public class Groupe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupeId;

	private String descriptionGroupe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@OneToMany(mappedBy = "groupe")
	private Collection<GroupeUtilisateur> groupeUtilisateurs;

	public Groupe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Groupe(Long groupeId, String descriptionGroupe, Date dateDeCreation, Date derniereMiseAJour,
			Collection<GroupeUtilisateur> groupeUtilisateurs) {
		super();
		this.groupeId = groupeId;
		this.descriptionGroupe = descriptionGroupe;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.groupeUtilisateurs = groupeUtilisateurs;
	}	
}