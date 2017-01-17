package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.enumeration.Portee;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class CategorieProduit extends Entite {

	@Id
	private String categorieProduitId;

	@Transient
	private String categorieParentId;

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
	private Collection<CategorieProduit> categorieFilles = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<CategorieProduitTaxe> categorieProduitTaxes = Sets.newHashSet();
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorieProduits", cascade = CascadeType.ALL)
	@JoinTable(name = "categorie_produit_taxe", 
	joinColumns = @JoinColumn(name = "categorie_produit_id", referencedColumnName = "taxe_id"), 
	inverseJoinColumns = @JoinColumn(name = "taxe_id", referencedColumnName = "categorie_produit_id"))
	private Collection<Taxe> taxes = Sets.newHashSet();


	public void setCategorieParent(CategorieProduit categorieParent) {
		this.categorieParent = categorieParent;
		copierCategorieProduitTaxeParent(categorieParent);
	}

	public CategorieProduit() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public boolean isDetail() {
		return this.getPortee() == Portee.DETAIL;
	}

	public boolean isTotal(CategorieProduit categorie) {
		return !isDetail();
	}

	private void copierCategorieProduitTaxeParent(CategorieProduit parent) {
		if ((parent != null) && ((categorieProduitTaxes) != null) && (categorieProduitTaxes.isEmpty())) {
			setCategorieProduitTaxes(parent.getCategorieProduitTaxes());
		}
	}
	
	@PrePersist
	private void setKey() {
		setCategorieParentId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
		setCategorieParentId(categorieParent.getCategorieParentId());
	}
}
