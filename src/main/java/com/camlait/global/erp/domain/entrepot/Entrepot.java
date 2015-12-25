package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
public class Entrepot extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entrepotId;

	@Column(name = "codeEntrepot", nullable = false, unique = true)
	private String codeEntrepot;

	private String descriptionEntrepot;

	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	@OneToMany(mappedBy = "entrepot")
	private Collection<Magasin> magasins;

	public Long getEntrepotId() {
		return entrepotId;
	}

	public void setEntrepotId(Long entrepotId) {
		this.entrepotId = entrepotId;
	}

	public String getCodeEntrepot() {
		return codeEntrepot;
	}

	public void setCodeEntrepot(String codeEntrepot) {
		this.codeEntrepot = codeEntrepot;
	}

	public String getDescriptionEntrepot() {
		return descriptionEntrepot;
	}

	public void setDescriptionEntrepot(String descriptionEntrepot) {
		this.descriptionEntrepot = descriptionEntrepot;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
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

	public Collection<Magasin> getMagasins() {
		return magasins;
	}

	public void setMagasins(Collection<Magasin> magasins) {
		this.magasins = magasins;
	}

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeEntrepot == null) ? 0 : codeEntrepot.hashCode());
		result = prime * result + ((entrepotId == null) ? 0 : entrepotId.hashCode());
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
		Entrepot other = (Entrepot) obj;
		if (codeEntrepot == null) {
			if (other.codeEntrepot != null)
				return false;
		} else if (!codeEntrepot.equals(other.codeEntrepot))
			return false;
		if (entrepotId == null) {
			if (other.entrepotId != null)
				return false;
		} else if (!entrepotId.equals(other.entrepotId))
			return false;
		return true;
	}

	public Entrepot() {

	}
}
