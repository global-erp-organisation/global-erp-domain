package com.camlait.global.erp.domain.document.commerciaux;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.produit.CategorieProduit;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
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
@EqualsAndHashCode(callSuper = true)
@Builder
public class Taxe extends Entite {

	@Id
	private String taxeId;

	@Column(name = "codeTaxe", unique = true, nullable = false)
	private String codeTaxe;

	private String taxeDescription;

	private double valeurPourcentage;

	private Date dateDeCreation;

	private Date derniereMiseAJour;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "taxes", cascade = CascadeType.ALL)
	@JoinTable(name = "produit_taxe", 
	joinColumns = @JoinColumn(name = "taxeId", referencedColumnName = "produitId"), 
	inverseJoinColumns = @JoinColumn(name = "produitId", referencedColumnName = "taxeId"))
	private Collection<Produit> produits = Sets.newHashSet();
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "taxes", cascade = CascadeType.ALL)
	@JoinTable(name = "categorie_produit_taxe", 
	joinColumns = @JoinColumn(name = "taxeId", referencedColumnName = "categorieProduitId"), 
	inverseJoinColumns = @JoinColumn(name = "categorieProduitId", referencedColumnName = "taxeId"))
	private Collection<CategorieProduit> categorieProduits = Sets.newHashSet();


	public Taxe(String taxeId, String codeTaxe) {
		super();
		this.taxeId = taxeId;
		this.codeTaxe = codeTaxe;
	}

	public Taxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	@PrePersist
	private void setKey() {
		setTaxeId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
	}


}
