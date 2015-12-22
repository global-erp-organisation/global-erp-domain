package com.camlait.global.erp.domain.produit;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.enumeration.Portee;

@Entity
public class CategorieProduit extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categorieProduitId")
	private Long id;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private CategorieProduit categorieParent;

	@Column(name = "cedCategorieProduit", unique = true, nullable = false)
	private String codeCategorieProduit;

	@Column(name = "descriptionCategorie")
	private String descriptionCategorie;

	private Portee portee;

	@Column(name = "categorieTaxable")
	private boolean categorieTaxable;

	@Column(name = "dateDeCreation")
	private DateTime dateDeCreation;

	@Column(name = "derniereMiseAJour")
	private DateTime derniereMiseAJour;

	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits;

	public Long getCategorieProduitId() {
		return id;
	}

	public void setCategorieProduitId(Long categorieProduitId) {
		this.id = categorieProduitId;
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

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorieParent == null) ? 0 : categorieParent.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public CategorieProduit() {
		//
	}
}
