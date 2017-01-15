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
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.Portee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class CategorieProduit extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categorieProduitId;

	@Transient
	private Long categorieParentId;
	
	@JsonBackReference
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

	@JsonManagedReference
	@OneToMany(mappedBy = "categorieParent")
	private Collection<CategorieProduit> categorieFilles= Lists.newArrayList();

	@JsonManagedReference
	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits = Lists.newArrayList();

	@JsonManagedReference
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<CategorieProduitTaxe> categorieProduitTaxes = Lists.newArrayList();

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
}
