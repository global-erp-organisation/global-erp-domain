package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PartenaireImmobilisation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientImmoId;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	@ManyToOne
	@JoinColumn(name = "immoId")
	private Immobilisation immobilisation;

	private Date dateAllocation;

	@Column(name = "actif")
	private boolean actif;

	private Date dateDeCreation;
	private Date derniereMiseAJour;

	public Long getClientImmoId() {
		return clientImmoId;
	}

	public void setClientImmoId(Long clientImmoId) {
		this.clientImmoId = clientImmoId;
	}

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	public Immobilisation getImmobilisation() {
		return immobilisation;
	}

	public void setImmobilisation(Immobilisation immobilisation) {
		this.immobilisation = immobilisation;
	}

	public Date getDateAllocation() {
		return dateAllocation;
	}

	public void setDateAllocation(Date dateAllocation) {
		this.dateAllocation = dateAllocation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateCreation) {
		this.dateDeCreation = dateCreation;
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
		result = prime * result + ((clientImmoId == null) ? 0 : clientImmoId.hashCode());
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
		PartenaireImmobilisation other = (PartenaireImmobilisation) obj;
		if (clientImmoId == null) {
			if (other.clientImmoId != null)
				return false;
		} else if (!clientImmoId.equals(other.clientImmoId))
			return false;
		return true;
	}

	public PartenaireImmobilisation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());

	}

}
