package com.camlait.global.erp.domain.produit;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
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
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = { "taxes", "categorieFilles", "produits" })
@ToString(exclude = { "taxes", "categorieFilles", "produits" })
@Builder
@Table(name = "`produit-categorie-produits`")
public class CategorieProduit extends Entite {

	@Id
	private String categorieProduitId;

	@Transient
	private String categorieParentId;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
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
	@OneToMany(mappedBy = "categorieParent", cascade = CascadeType.ALL)
	private Set<CategorieProduit> categorieFilles = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Set<Produit> produits = Sets.newHashSet();

	@JsonManagedReference
	@ManyToMany(mappedBy = "categorieProduits", cascade = CascadeType.ALL)
	private Set<Taxe> taxes = Sets.newHashSet();

	public void setCategorieParent(CategorieProduit categorieParent) {
		this.categorieParent = categorieParent;
		copierTaxeParent(categorieParent);
	}

	public CategorieProduit() {
	}

	public boolean isDetail() {
		return this.getPortee() == Portee.DETAIL;
	}

	public boolean isTotal(CategorieProduit categorie) {
		return !isDetail();
	}

	private void copierTaxeParent(CategorieProduit categorieParent) {
		final Set<Taxe> parentTaxes = categorieParent != null ? categorieParent.getTaxes() : null;
		if (!CollectionUtils.isNullOrEmpty(parentTaxes) && (taxes.isEmpty())) {
			setTaxes(parentTaxes);
		}
	}

	@PrePersist
	private void setKey() {
		setCategorieProduitId(Utility.getUidFor(categorieProduitId));
		setCategorieParentId(categorieParent != null ? categorieParent.categorieParentId : null);
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}

	@Override
	public void postConstructOperation() {
		setCategorieParentId(categorieParent.getCategorieParentId());
	}
}
