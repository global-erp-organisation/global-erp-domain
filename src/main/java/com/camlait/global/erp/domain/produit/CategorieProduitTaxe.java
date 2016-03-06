package com.camlait.global.erp.domain.produit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
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
public class CategorieProduitTaxe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categorieProduitTaxeId;

	@ManyToOne
	@JoinColumn(name = "categorieProduitId")
	private CategorieProduit categorie;

	@ManyToOne
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public CategorieProduitTaxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public CategorieProduitTaxe(Long categorieProduitTaxeId, CategorieProduit categorie, Taxe taxe, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.categorieProduitTaxeId = categorieProduitTaxeId;
		this.categorie = categorie;
		this.taxe = taxe;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
