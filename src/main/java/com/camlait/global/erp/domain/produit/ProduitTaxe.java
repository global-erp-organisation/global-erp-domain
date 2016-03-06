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
public class ProduitTaxe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long produitTaxeId;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public ProduitTaxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public ProduitTaxe(Long produitTaxeId, Produit produit, Taxe taxe, Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.produitTaxeId = produitTaxeId;
		this.produit = produit;
		this.taxe = taxe;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
