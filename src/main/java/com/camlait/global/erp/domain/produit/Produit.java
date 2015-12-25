package com.camlait.global.erp.domain.produit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Produit extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long produitId;

	@Column(name = "codeProduit", unique = true, nullable = false)
	private String codeProduit;

	private String descriptionProduit;

	private double prixUnitaireProduit;

	@ManyToOne
	@JoinColumn(name = "categorieProduitId")
	private CategorieProduit categorie;

	private boolean produitTaxable;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

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

	@Override
	public String toString() {
		return "[" + codeProduit + "] " + descriptionProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((codeProduit == null) ? 0 : codeProduit.hashCode());
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
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (codeProduit == null) {
			if (other.codeProduit != null)
				return false;
		} else if (!codeProduit.equals(other.codeProduit))
			return false;
		return true;
	}

	public Produit() {
		//
	}
}
