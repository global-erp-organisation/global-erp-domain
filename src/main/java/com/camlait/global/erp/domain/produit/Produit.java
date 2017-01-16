package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.inventaire.FicheDeStock;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
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

	@Transient
	private Long categorieProduitId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "categorieProduitId")
	private CategorieProduit categorie;

	private boolean produitTaxable;

	@JsonManagedReference
	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	private Collection<ProduitTaxe> produitTaxes = Sets.newHashSet();

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private boolean suiviEnStock;

	@JsonManagedReference
	@OneToMany(mappedBy = "produit")
	private Collection<Stock> stocks = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "produit")
	private Collection<FicheDeStock> ficheDeStocks = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "produit")
	private Collection<Tarification> tarifications = Sets.newHashSet();

	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
		copieCategorieProduitTaxe();
	}

	public Produit() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Long quantiteDisponible(Magasin m) {
		return this.getStocks().stream().filter(s -> s.getMagasin().getMagasinId().equals(m.getMagasinId()))
				.mapToLong(s -> s.getQuantiteDisponible()).sum();
	}

	private void copieCategorieProduitTaxe() {
		if (categorie != null) {
			final Collection<CategorieProduitTaxe> ctaxes = categorie.getCategorieProduitTaxes();
			if ((ctaxes != null) && (!ctaxes.isEmpty())) {
				final Collection<ProduitTaxe> taxes = ctaxes.parallelStream().map(c -> {
					return ProduitTaxe.builder().produit(this).produictId(this.getProduitId()).taxe(c.getTaxe())
							.build();
				}).collect(Collectors.toList());
				setProduitTaxes(taxes);
			}
		}
	}
}
