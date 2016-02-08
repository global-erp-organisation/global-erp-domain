package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Tarif extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tarifId;
	private String descriptionTarif;

	public Long getTarifId() {
		return tarifId;
	}

	public void setTarifId(Long tarifId) {
		this.tarifId = tarifId;
	}

	public String getDescriptionTarif() {
		return descriptionTarif;
	}

	public void setDescriptionTarif(String descriptionTarif) {
		this.descriptionTarif = descriptionTarif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tarifId == null) ? 0 : tarifId.hashCode());
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
		Tarif other = (Tarif) obj;
		if (tarifId == null) {
			if (other.tarifId != null)
				return false;
		} else if (!tarifId.equals(other.tarifId))
			return false;
		return true;
	}

	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarif(String descriptionTarif) {
		super();
		this.descriptionTarif = descriptionTarif;
	}
}
