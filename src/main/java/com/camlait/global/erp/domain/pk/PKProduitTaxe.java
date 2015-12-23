package com.camlait.global.erp.domain.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class PKProduitTaxe implements Serializable{
	private Long produitId;
	private Long TaxeId;

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	public Long getTaxeId() {
		return TaxeId;
	}

	public void setTaxeId(Long taxeId) {
		TaxeId = taxeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TaxeId == null) ? 0 : TaxeId.hashCode());
		result = prime * result + ((produitId == null) ? 0 : produitId.hashCode());
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
		PKProduitTaxe other = (PKProduitTaxe) obj;
		if (TaxeId == null) {
			if (other.TaxeId != null)
				return false;
		} else if (!TaxeId.equals(other.TaxeId))
			return false;
		if (produitId == null) {
			if (other.produitId != null)
				return false;
		} else if (!produitId.equals(other.produitId))
			return false;
		return true;
	}

}
