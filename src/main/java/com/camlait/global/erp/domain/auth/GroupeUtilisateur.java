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
public class GroupeUtilisateur extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupeUtilissateurId;

	@ManyToOne
	@JoinColumn(name = "groupeId")
	private Groupe groupe;

	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilsateur;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public GroupeUtilisateur() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public GroupeUtilisateur(Long groupeUtilissateurId, Groupe groupe, Utilisateur utilsateur, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.groupeUtilissateurId = groupeUtilissateurId;
		this.groupe = groupe;
		this.utilsateur = utilsateur;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}
	
}
