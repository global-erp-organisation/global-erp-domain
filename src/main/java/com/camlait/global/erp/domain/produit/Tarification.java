package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Zone;

@Entity
public class Tarification extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tarificationId;

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = "tarifId")
	private Tarif tarif;

	private double prixUnitaire;
	private double prixUnitaireMarge;

	public Long getTarificationId() {
		return tarificationId;
	}

	public void setTarificationId(Long tarificationId) {
		this.tarificationId = tarificationId;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getPrixUnitaireMarge() {
		return prixUnitaireMarge;
	}

	public void setPrixUnitaireMarge(double prixUnitaireMarge) {
		this.prixUnitaireMarge = prixUnitaireMarge;
	}

	public Tarif getTarif() {
		return tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tarificationId == null) ? 0 : tarificationId.hashCode());
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
		Tarification other = (Tarification) obj;
		if (tarificationId == null) {
			if (other.tarificationId != null)
				return false;
		} else if (!tarificationId.equals(other.tarificationId))
			return false;
		return true;
	}

	public Tarification() {
		super();
		// TODO Auto-generated constructor stub
	}
}
