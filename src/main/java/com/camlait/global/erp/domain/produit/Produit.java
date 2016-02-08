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

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "produitId")
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

	@OneToMany(mappedBy="produit")
	private Collection<Tarification> tarifications;
	
	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public double getPrixUnitaireProduit() {
		return prixUnitaireProduit;
	}

	public void setPrixUnitaireProduit(double prixUnitaireProduit) {
		this.prixUnitaireProduit = prixUnitaireProduit;
	}

	public CategorieProduit getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
		copieCategorieProduitTaxe();
	}

	public boolean isProduitTaxable() {
		return produitTaxable;
	}

	public void setProduitTaxable(boolean produitTaxable) {
		this.produitTaxable = produitTaxable;
	}

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(Date derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	public Collection<ProduitTaxe> getProduitTaxes() {
		return produitTaxes;
	}

	public void setProduitTaxes(Collection<ProduitTaxe> produitTaxes) {
		this.produitTaxes = produitTaxes;
	}

	public double getPrixUnitaireMarge() {
		return prixUnitaireMarge;
	}

	public void setPrixUnitaireMarge(double prixUnitaireMarge) {
		this.prixUnitaireMarge = prixUnitaireMarge;
	}

	public boolean isSuiviEnStock() {
		return suiviEnStock;
	}

	public void setSuiviEnStock(boolean suiviEnStock) {
		this.suiviEnStock = suiviEnStock;
	}

	public Collection<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Collection<Stock> stocks) {
		this.stocks = stocks;
	}

	public Collection<FicheDeStock> getFicheDeStocks() {
		return ficheDeStocks;
	}

	public void setFicheDeStocks(Collection<FicheDeStock> ficheDeStocks) {
		this.ficheDeStocks = ficheDeStocks;
	}
	
	public Collection<Tarification> getTarifications() {
		return tarifications;
	}

	public void setTarifications(Collection<Tarification> tarifications) {
		this.tarifications = tarifications;
	}

	@Override
	public String toString() {
		return "[" + produitId + "]-[" + codeProduit + "] " + descriptionProduit + " [pu]=" + prixUnitaireProduit
				+ " [pm]=" + prixUnitaireMarge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produitId == null) ? 0 : produitId.hashCode());
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
		Produit other = (Produit) obj;
		if (produitId == null) {
			if (other.produitId != null)
				return false;
		} else if (!produitId.equals(other.produitId))
			return false;
		return true;
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
}
