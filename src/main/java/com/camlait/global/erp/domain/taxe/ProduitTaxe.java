package com.camlait.global.erp.domain.taxe;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.camlait.global.erp.domain.pk.PKProduitTaxe;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.taxe.Taxe;

@Entity
public class ProduitTaxe {

	@EmbeddedId
	private PKProduitTaxe produitTaxeId;
	private Produit produit;
	private Taxe taxe;

	public PKProduitTaxe getProduitTaxeId() {
		return produitTaxeId;
	}

	public void setProduitTaxeId(PKProduitTaxe produitTaxeId) {
		this.produitTaxeId = produitTaxeId;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produitTaxeId == null) ? 0 : produitTaxeId.hashCode());
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
		ProduitTaxe other = (ProduitTaxe) obj;
		if (produitTaxeId == null) {
			if (other.produitTaxeId != null)
				return false;
		} else if (!produitTaxeId.equals(other.produitTaxeId))
			return false;
		return true;
	}

}
