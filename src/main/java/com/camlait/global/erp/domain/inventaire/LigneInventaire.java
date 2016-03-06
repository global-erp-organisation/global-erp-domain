package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
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
public class LigneInventaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneInventaireId;

	@ManyToOne
	@JoinColumn(name = "inventaireId")
	private Inventaire inventaire;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteReelle;

	private Long quantiteAjustee;

	private double prixUnitaireReelle;

	private double prixUnitaireAjustee;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public LigneInventaire() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public LigneInventaire(Long ligneInventaireId, Inventaire inventaire, Produit produit, Long quantiteReelle,
			Long quantiteAjustee, double prixUnitaireReelle, double prixUnitaireAjustee, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.ligneInventaireId = ligneInventaireId;
		this.inventaire = inventaire;
		this.produit = produit;
		this.quantiteReelle = quantiteReelle;
		this.quantiteAjustee = quantiteAjustee;
		this.prixUnitaireReelle = prixUnitaireReelle;
		this.prixUnitaireAjustee = prixUnitaireAjustee;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
