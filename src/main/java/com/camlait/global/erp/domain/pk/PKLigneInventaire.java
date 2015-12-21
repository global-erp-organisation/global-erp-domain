package com.camlait.global.erp.domain.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PKLigneInventaire implements Serializable {

	private Long inventaireId;

	private Long produitId;

	public Long getInventaireId() {
		return inventaireId;
	}

	public void setInventaireId(Long inventaireId) {
		this.inventaireId = inventaireId;
	}

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventaireId == null) ? 0 : inventaireId.hashCode());
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
		PKLigneInventaire other = (PKLigneInventaire) obj;
		if (inventaireId == null) {
			if (other.inventaireId != null)
				return false;
		} else if (!inventaireId.equals(other.inventaireId))
			return false;
		if (produitId == null) {
			if (other.produitId != null)
				return false;
		} else if (!produitId.equals(other.produitId))
			return false;
		return true;
	}

}
