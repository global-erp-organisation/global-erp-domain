package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.produit.Produit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Stock extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	private Long quantiteDisponible;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Stock() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Stock(Long stockId, Produit produit, Magasin magasin, Long quantiteDisponible, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.stockId = stockId;
		this.produit = produit;
		this.magasin = magasin;
		this.quantiteDisponible = quantiteDisponible;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
