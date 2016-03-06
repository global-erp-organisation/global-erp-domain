package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.inventaire.FicheDeStock;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "produitId")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Produit extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long produitId;

	@Column(name = "codeProduit", unique = true, nullable = false)
	private String codeProduit;

	private String descriptionProduit;

	private double prixUnitaireProduit;

	private double prixUnitaireMarge;

	@ManyToOne
	@JoinColumn(name = "categorieProduitId")
	private CategorieProduit categorie;

	private boolean produitTaxable;

	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	private Collection<ProduitTaxe> produitTaxes;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private boolean suiviEnStock;

	@OneToMany(mappedBy = "produit")
	private Collection<Stock> stocks;

	@OneToMany(mappedBy = "produit")
	private Collection<FicheDeStock> ficheDeStocks;

	@OneToMany(mappedBy = "produit")
	private Collection<Tarification> tarifications;

	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
		copieCategorieProduitTaxe();
	}

	public Produit() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	private void copieCategorieProduitTaxe() {
		final Collection<ProduitTaxe> taxes = new HashSet<>();
		if (categorie != null) {
			final Collection<CategorieProduitTaxe> ctaxes = categorie.getCategorieProduitTaxes();
			if ((ctaxes != null) && (!ctaxes.isEmpty())) {
				ctaxes.stream().forEach(c -> {
					ProduitTaxe pt = new ProduitTaxe();
					pt.setProduit(this);
					pt.setTaxe(c.getTaxe());
					taxes.add(pt);
				});
				setProduitTaxes(taxes);
			}
		}
	}

	public Produit(Long produitId, String codeProduit, String descriptionProduit, double prixUnitaireProduit,
			double prixUnitaireMarge, CategorieProduit categorie, boolean produitTaxable,
			Collection<ProduitTaxe> produitTaxes, Date dateDeCreation, Date derniereMiseAJour, boolean suiviEnStock,
			Collection<Stock> stocks, Collection<FicheDeStock> ficheDeStocks, Collection<Tarification> tarifications) {
		super();
		this.produitId = produitId;
		this.codeProduit = codeProduit;
		this.descriptionProduit = descriptionProduit;
		this.prixUnitaireProduit = prixUnitaireProduit;
		this.prixUnitaireMarge = prixUnitaireMarge;
		this.categorie = categorie;
		this.produitTaxable = produitTaxable;
		this.produitTaxes = produitTaxes;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.suiviEnStock = suiviEnStock;
		this.stocks = stocks;
		this.ficheDeStocks = ficheDeStocks;
		this.tarifications = tarifications;
	}

}
