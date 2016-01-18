package com.camlait.global.erp.domain.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Ressource extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ressourceId;
	
	@ManyToOne
	@JoinColumn(name = "ressourceParentId")
	private Ressource ressourceParent;

	private String descriptionRessource;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String classeIcon;

	private String appLocalisation;
	
	
	@OneToMany(mappedBy="ressourceParent",fetch=FetchType.EAGER)
	private Collection<Ressource> ressourceFilles;

	public Long getRessourceId() {
		return ressourceId;
	}

	public void setRessourceId(Long meduId) {
		this.ressourceId = meduId;
	}

	public Ressource getRessourceParent() {
		return ressourceParent;
	}

	public void setRessourceParent(Ressource menuParent) {
		this.ressourceParent = menuParent;
	}

	public String getDescriptionRessource() {
		return descriptionRessource;
	}

	public void setDescriptionRessource(String descriptionMenu) {
		this.descriptionRessource = descriptionMenu;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(Date derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	public String getClasseIcon() {
		return classeIcon;
	}

	public void setClasseIcon(String classeIcon) {
		this.classeIcon = classeIcon;
	}

	public String getAppLocalisation() {
		return appLocalisation;
	}

	public void setAppLocalisation(String appLocalisation) {
		this.appLocalisation = appLocalisation;
	}

	public Collection<Ressource> getRessourceFilles() {
		return ressourceFilles;
	}

	public void setRessourceFilles(Collection<Ressource> ressourceFils) {
		this.ressourceFilles = ressourceFils;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ressourceId == null) ? 0 : ressourceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ressource other = (Ressource) obj;
		if (ressourceId == null) {
			if (other.ressourceId != null)
				return false;
		} else if (!ressourceId.equals(other.ressourceId))
			return false;
		return true;
	}

	public Ressource() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Ressource(String descriptionMenu) {
		this.descriptionRessource = descriptionMenu;
	}

	public Ressource(String descriptionMenu, Ressource menuParent) {
		super();
		this.descriptionRessource = descriptionMenu;
		this.ressourceParent = menuParent;
	}
}
