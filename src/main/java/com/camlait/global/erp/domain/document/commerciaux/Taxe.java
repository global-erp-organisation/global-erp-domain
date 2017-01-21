package com.camlait.global.erp.domain.document.commerciaux;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

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
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "produits", "categorieProduits" })
@ToString(exclude = { "produits", "categorieProduits" })
@Builder
@Table(name = "`taxe-taxes`")
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "`produit-produit-taxe`")
	private Collection<Produit> produits = Sets.newHashSet();

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "`produit-categorie-produit-taxe`")
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
		setTaxeId(Utility.getUidFor(taxeId));
	}

	@Override
	public void postConstructOperation() {
	}

}
