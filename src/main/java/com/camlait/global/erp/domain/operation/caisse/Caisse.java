package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
public class Caisse extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caisseId;

	@Column(unique = true, nullable = false)
	private String codeCaisse;

	private String descriptionCaisse;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
	private Employe responsable;

	public Long getCaisseId() {
		return caisseId;
	}

	public void setCaisseId(Long caisseId) {
		this.caisseId = caisseId;
	}

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

	}
}
