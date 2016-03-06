package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
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

	private boolean suiviEnStock;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@OneToMany(mappedBy = "categorieParent")
	private Collection<CategorieProduit> categorieFilles;

	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<CategorieProduitTaxe> categorieProduitTaxes;

	public void setCategorieParent(CategorieProduit categorieParent) {
		this.categorieParent = categorieParent;
		copierCategorieProduitTaxeParent(categorieParent);
	}

	public CategorieProduit() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	private void copierCategorieProduitTaxeParent(CategorieProduit parent) {
		if ((parent != null) && ((categorieProduitTaxes) != null) && (categorieProduitTaxes.isEmpty())) {
			setCategorieProduitTaxes(parent.getCategorieProduitTaxes());
		}
	}

	public CategorieProduit(Long categorieProduitId, CategorieProduit categorieParent, String codeCategorieProduit,
			String descriptionCategorie, Portee portee, boolean categorieTaxable, boolean suiviEnStock,
			Date dateDeCreation, Date derniereMiseAJour, Collection<CategorieProduit> categorieFilles,
			Collection<Produit> produits, Collection<CategorieProduitTaxe> categorieProduitTaxes) {
		super();
		this.categorieProduitId = categorieProduitId;
		this.categorieParent = categorieParent;
		this.codeCategorieProduit = codeCategorieProduit;
		this.descriptionCategorie = descriptionCategorie;
		this.portee = portee;
		this.categorieTaxable = categorieTaxable;
		this.suiviEnStock = suiviEnStock;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.categorieFilles = categorieFilles;
		this.produits = produits;
		this.categorieProduitTaxes = categorieProduitTaxes;
	}
}
