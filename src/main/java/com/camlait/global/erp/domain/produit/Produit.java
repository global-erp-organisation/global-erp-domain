package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.inventaire.FicheDeStock;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.camlait.global.erp.domain.prix.PriceType;
import com.camlait.global.erp.domain.prix.Tarification;
import com.camlait.global.erp.domain.prix.UnitPrice;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = { "unitPrices", "taxes", "stocks", "ficheDeStocks", "tarifications" })
@ToString(exclude = { "unitPrices", "taxes", "stocks", "ficheDeStocks", "tarifications" })
@Builder
public class Produit extends Entite {

	@Id
	private String produitId;

	@Column(name = "codeProduit", unique = true, nullable = false)
	private String codeProduit;

	private String descriptionProduit;

	@JsonManagedReference
	@OneToMany(mappedBy = "produit")
	private Collection<UnitPrice> unitPrices = Sets.newHashSet();

	@Transient
	private String categorieProduitId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "categorieProduitId")
	private CategorieProduit categorie;

	private boolean produitTaxable;

	private Double defaultUnitprice;

	@JsonManagedReference
	@ManyToMany(mappedBy = "produits", cascade = CascadeType.ALL)
	private Collection<Taxe> taxes = Sets.newHashSet();

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
	}

	public Produit() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Long availableQuantity(Magasin m) {
		return this.getStocks().stream().filter(s -> s.getMagasin().getMagasinId().equals(m.getMagasinId()))
				.mapToLong(s -> s.getQuantiteDisponible()).sum();
	}

	public Boolean isAvailable(Magasin m, Long quantiteVoulue) {
		return availableQuantity(m) >= quantiteVoulue;
	}

	@PostConstruct
	public void copieCategorieProduitTaxe() {
		if (categorie != null) {
			final Collection<Taxe> ctaxes = categorie.getTaxes();
			if (!CollectionUtils.isNullOrEmpty(ctaxes) && CollectionUtils.isNullOrEmpty(taxes)) {
				setTaxes(taxes);
			}
		}
	}

	@PrePersist
	private void setKey() {
		setProduitId(Utility.getUidFor(produitId));
	}

	@Override
	public void postConstructOperation() {
		setCategorieProduitId(categorie.getCategorieProduitId());
	}

	/**
	 * Retrieve the unit price of the current product based on the given price
	 * type.
	 * 
	 * @param type
	 *            Provide price type.
	 * @return The unit price that belongs to the given type or the default unit
	 *         price if no record found for the given price type.
	 */
	public Double getUnitPriceByType(PriceType type) {
		final Optional<UnitPrice> p = unitPrices.stream().filter(u -> type.getPriceTypeId().equals(u.getPriceTypeId()))
				.findFirst();
		if (p.isPresent()) {
			return p.get().getValue();
		}
		return defaultUnitprice;
	}
}
