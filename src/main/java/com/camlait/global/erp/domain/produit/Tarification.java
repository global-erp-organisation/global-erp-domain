package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Zone;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
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

	public Tarification() {
	}

	public Tarification(Long tarificationId, Zone zone, Produit produit, Tarif tarif, double prixUnitaire,
			double prixUnitaireMarge) {
		super();
		this.tarificationId = tarificationId;
		this.zone = zone;
		this.produit = produit;
		this.tarif = tarif;
		this.prixUnitaire = prixUnitaire;
		this.prixUnitaireMarge = prixUnitaireMarge;
	}

}
