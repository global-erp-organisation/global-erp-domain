package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.partenaire.Client;

@Entity
public class Immobilisation extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codeImmo", nullable = false, unique = true)
	private String codeImmo;

	@Column(name = "dateAcquisition")
	private DateTime dateAcquisition;

	@Column(name = "dateMiseEnService")
	private DateTime dateMiseEnService;

	@Column(name = "dateDeCreation")
	private DateTime dateDeCreation;

	@Column(name = "derniereMiseAJour")
	private DateTime derniereMiseAJour;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private Client client;

	public Long getImmoId() {
		return id;
	}

	public void setImmoId(Long immoId) {
		this.id = immoId;
	}

	public String getCodeImmo() {
		return codeImmo;
	}

	public void setCodeImmo(String codeImmo) {
		this.codeImmo = codeImmo;
	}

	public DateTime getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(DateTime dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public DateTime getDateMiseEnService() {
		return dateMiseEnService;
	}

	public void setDateMiseEnService(DateTime dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeImmo == null) ? 0 : codeImmo.hashCode());
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
		Immobilisation other = (Immobilisation) obj;
		if (codeImmo == null) {
			if (other.codeImmo != null)
				return false;
		} else if (!codeImmo.equals(other.codeImmo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Immobilisation() {

	}

}
