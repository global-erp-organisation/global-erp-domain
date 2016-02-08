package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;

@Entity
public class GroupePartenaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupePartenaireId;

	private String descriptionGroupePartenaire;

	@OneToMany(mappedBy = "groupePartenaire")
	private Collection<Partenaire> partenaires;

	public Long getGroupePartenaireId() {
		return groupePartenaireId;
	}

	public void setGroupePartenaireId(Long groupePartenaireId) {
		this.groupePartenaireId = groupePartenaireId;
	}

	public String getDescriptionGroupePartenaire() {
		return descriptionGroupePartenaire;
	}

	public void setDescriptionGroupePartenaire(String descriptionGroupePartenaire) {
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
	}

	public Collection<Partenaire> getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(Collection<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupePartenaireId == null) ? 0 : groupePartenaireId.hashCode());
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
		GroupePartenaire other = (GroupePartenaire) obj;
		if (groupePartenaireId == null) {
			if (other.groupePartenaireId != null)
				return false;
		} else if (!groupePartenaireId.equals(other.groupePartenaireId))
			return false;
		return true;
	}

	public GroupePartenaire(String descriptionGroupePartenaire) {
		super();
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
	}

	public GroupePartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
}
