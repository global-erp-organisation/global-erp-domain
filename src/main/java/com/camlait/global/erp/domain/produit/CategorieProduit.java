package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.Portee;

@Entity
public class CategorieProduit extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categorieProduitId;

	@ManyToOne
	@JoinColumn(name = "categorieParentId")
	private CategorieProduit categorieParent;

	@Column(name = "codeCategorieProduit", unique = true)
	private String codeCategorieProduit;

	private String descriptionCategorie;

	@Enumerated(EnumType.STRING)
	private Portee portee;

	private boolean categorieTaxable;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits;

	public Long getCategorieProduitId() {
		return categorieProduitId;
	}

	public void setCategorieProduitId(Long categorieProduitId) {
		this.categorieProduitId = categorieProduitId;
	}

	public CategorieProduit getCategorieParent() {
		return categorieParent;
	}

	public void setCategorieParent(CategorieProduit categorieParent) {
		this.categorieParent = categorieParent;
	}

	public String getCodeCategorieProduit() {
		return codeCategorieProduit;
	}

	public void setCodeCategorieProduit(String codeCategorieProduit) {
		this.codeCategorieProduit = codeCategorieProduit;
	}

	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}

	public Portee getPortee() {
		return portee;
	}

	public void setPortee(Portee portee) {
		this.portee = portee;
	}

	public boolean isCategorieTaxable() {
		return categorieTaxable;
	}

	public void setCategorieTaxable(boolean categorieTaxable) {
		this.categorieTaxable = categorieTaxable;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
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
		return "[" + codeCategorieProduit + "] " + descriptionCategorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorieParent == null) ? 0 : categorieParent.hashCode());
		result = prime * result + ((categorieProduitId == null) ? 0 : categorieProduitId.hashCode());
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
		CategorieProduit other = (CategorieProduit) obj;
		if (categorieParent == null) {
			if (other.categorieParent != null)
				return false;
		} else if (!categorieParent.equals(other.categorieParent))
			return false;
		if (categorieProduitId == null) {
			if (other.categorieProduitId != null)
				return false;
		} else if (!categorieProduitId.equals(other.categorieProduitId))
			return false;
		return true;
	}

	public CategorieProduit() {
		//
	}
}
