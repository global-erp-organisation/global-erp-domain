package com.camlait.global.erp.domain.stock;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.pk.PKStock;
import com.camlait.global.erp.domain.produit.Produit;

@Entity
public class Stock extends Entite {

	@EmbeddedId
	private PKStock stockId;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION, updatable = false, insertable = false)
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION, updatable = false, insertable = false)
	private Magasin magasin;

	private Long quantiteDisponible;

	private DateTime dateDeCreation;

	private DateTime derniereMiseAJour;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Long getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setQuantiteDisponible(Long quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
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

	public PKStock getStockId() {
		return stockId;
	}

	public void setStockId(PKStock stockId) {
		this.stockId = stockId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
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
		Stock other = (Stock) obj;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		return true;
	}

	public Stock() {

	}
}
