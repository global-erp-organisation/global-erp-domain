package com.camlait.global.erp.domain.auth;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class RessourceGroupe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceGroupeId;

	@ManyToOne
	@JoinColumn(name = "groupeId")
	private Groupe groupe;

	@ManyToOne
	@JoinColumn(name = "ressourceId")
	private Ressource ressource;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public RessourceGroupe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public RessourceGroupe(Long resourceGroupeId, Groupe groupe, Ressource ressource, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.resourceGroupeId = resourceGroupeId;
		this.groupe = groupe;
		this.ressource = ressource;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}
	
}
