package com.camlait.global.erp.domain.auth;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Groupe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupeId;

	private String descriptionGroupe;

	@OneToMany(mappedBy = "groupe")
	@JsonManagedReference
	private Collection<GroupeUtilisateur> groupeUtilisateurs;

	public Long getGroupeId() {
		return groupeId;
	}

	public void setGroupeId(Long groupeId) {
		this.groupeId = groupeId;
	}

	public String getDescriptionGroupe() {
		return descriptionGroupe;
	}

	public void setDescriptionGroupe(String descriptionGroupe) {
		this.descriptionGroupe = descriptionGroupe;
	}

	public Collection<GroupeUtilisateur> getGroupeUtilisateurs() {
		return groupeUtilisateurs;
	}

	public void setGroupeUtilisateurs(Collection<GroupeUtilisateur> groupeUtilisateurs) {
		this.groupeUtilisateurs = groupeUtilisateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupeId == null) ? 0 : groupeId.hashCode());
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
		Groupe other = (Groupe) obj;
		if (groupeId == null) {
			if (other.groupeId != null)
				return false;
		} else if (!groupeId.equals(other.groupeId))
			return false;
		return true;
	}

	public Groupe() {
		super();
	}
}