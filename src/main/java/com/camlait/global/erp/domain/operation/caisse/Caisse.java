package com.camlait.global.erp.domain.operation.caisse;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
public class Caisse extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caisseId;

	@Column(name = "codeCaisse", unique = true, nullable = false)
	private String codeCaisse;

	private String descriptionCaisse;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public String getCodeCaisse() {
		return codeCaisse;
	}

	public void setCodeCaisse(String codeCaisse) {
		this.codeCaisse = codeCaisse;
	}

	public String getDescriptionCaisse() {
		return descriptionCaisse;
	}

	public void setDescriptionCaisse(String descriptionCaisse) {
		this.descriptionCaisse = descriptionCaisse;
	}

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}

	public Long getCaisseId() {
		return caisseId;
	}

	public void setCaisseId(Long id) {
		this.caisseId = id;
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
		result = prime * result + ((caisseId == null) ? 0 : caisseId.hashCode());
		result = prime * result + ((codeCaisse == null) ? 0 : codeCaisse.hashCode());
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
		Caisse other = (Caisse) obj;
		if (caisseId == null) {
			if (other.caisseId != null)
				return false;
		} else if (!caisseId.equals(other.caisseId))
			return false;
		if (codeCaisse == null) {
			if (other.codeCaisse != null)
				return false;
		} else if (!codeCaisse.equals(other.codeCaisse))
			return false;
		return true;
	}

	public Caisse() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
