package com.camlait.global.erp.domain.taxe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;

@Entity
public class TaxeModele extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taxeModeleId;

	@ManyToOne
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	@ManyToOne
	@JoinColumn(name = "modeleDeTaxationId")
	private ModeleDeTaxation modeleDeTaxation;

	public Long getTaxeModeleId() {
		return taxeModeleId;
	}

	public void setTaxeModeleId(Long taxeModeleId) {
		this.taxeModeleId = taxeModeleId;
	}

	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}

	public ModeleDeTaxation getModeleDeTaxation() {
		return modeleDeTaxation;
	}

	public void setModeleDeTaxation(ModeleDeTaxation modele) {
		this.modeleDeTaxation = modele;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taxeModeleId == null) ? 0 : taxeModeleId.hashCode());
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
		TaxeModele other = (TaxeModele) obj;
		if (taxeModeleId == null) {
			if (other.taxeModeleId != null)
				return false;
		} else if (!taxeModeleId.equals(other.taxeModeleId))
			return false;
		return true;
	}
}
