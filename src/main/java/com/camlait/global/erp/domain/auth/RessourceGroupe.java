package com.camlait.global.erp.domain.auth;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties=true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class RessourceGroupe extends Entite {

	@Id
	private String resourceGroupeId;

	@Transient
	private String groupId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "groupeId")
	private Groupe groupe;

	@Transient
	private String ressourceId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ressourceId")
	private Ressource ressource;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public RessourceGroupe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	public void setRessourceId(){
	    setRessourceId(getRessource().getRessourceId());
	}
	
	@PrePersist
	private void setKey() {
		setRessourceId(Utility.getUid());
	}
}
