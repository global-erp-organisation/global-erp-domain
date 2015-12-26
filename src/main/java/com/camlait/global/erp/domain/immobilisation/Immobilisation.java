package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Immobilisation extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long immoId;

	@Column(name = "codeImmo", nullable = false, unique = true)
	private String codeImmo;

	private Date dateAcquisition;

	private Date dateMiseEnService;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Long getImmoId() {
		return immoId;
	}

	public void setImmoId(Long immoId) {
		this.immoId = immoId;
	}

	public String getCodeImmo() {
		return codeImmo;
	}

	public void setCodeImmo(String codeImmo) {
		this.codeImmo = codeImmo;
	}

	public Date getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public Date getDateMiseEnService() {
		return dateMiseEnService;
	}

	public void setDateMiseEnService(Date dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeImmo == null) ? 0 : codeImmo.hashCode());
		result = prime * result + ((immoId == null) ? 0 : immoId.hashCode());
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
		Immobilisation other = (Immobilisation) obj;
		if (codeImmo == null) {
			if (other.codeImmo != null)
				return false;
		} else if (!codeImmo.equals(other.codeImmo))
			return false;
		if (immoId == null) {
			if (other.immoId != null)
				return false;
		} else if (!immoId.equals(other.immoId))
			return false;
		return true;
	}

	public Immobilisation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

}
