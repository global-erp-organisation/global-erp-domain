package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
public class Entrepot extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="codeEntrepot",nullable = false, unique = true)
	private String codeEntrepot;

	@Column(name="descriptionEntrepot")
	private String descriptionEntrepot;

	@ManyToOne
	@JoinColumn(name=GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Centre centre;

    @Column(name="dateDeCreation")
    private DateTime dateDeCreation;

    @Column(name="derniereMiseAJour")
    private DateTime derniereMiseAJour;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Employe responsable;

	@OneToMany(mappedBy = "entrepot")
	private Collection<Magasin> magasins;

	public Long getEntrepotId() {
		return id;
	}

	public void setEntrepotId(Long entrepotId) {
		this.id = entrepotId;
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

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Entrepot() {

	}
}
