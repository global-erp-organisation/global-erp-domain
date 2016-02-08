package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Ressource extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ressourceId;

	@ManyToOne
	@JoinColumn(name = "ressourceParentId")
	@JsonManagedReference
	private Ressource ressourceParent;

	private String title;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String icon;

	private String sref;

	private String href;

	@JsonBackReference
	@OneToMany(mappedBy = "ressourceParent", fetch = FetchType.EAGER)
	private Collection<Ressource> items;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String descriptionMenu) {
		this.title = descriptionMenu;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String classeIcon) {
		this.icon = classeIcon;
	}

	public String getSref() {
		return sref;
	}

	public void setSref(String appLocalisation) {
		this.sref = appLocalisation;
	}

	public Collection<Ressource> getItems() {
		return items;
	}

	public void setItems(Collection<Ressource> ressourceFils) {
		this.items = ressourceFils;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
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
		this.title = descriptionMenu;
	}

	public Ressource(String descriptionMenu, Ressource menuParent) {
		super();
		this.title = descriptionMenu;
		this.ressourceParent = menuParent;
	}
}
