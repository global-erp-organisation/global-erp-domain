package com.camlait.global.erp.domain.produit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class ProduitTaxe extends Entite {

	@Id
	private String produitTaxeId;

	@Transient
	private String produitId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	@Transient
	private String taxeId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public ProduitTaxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	@PrePersist
	private void setKey() {
		setProduitTaxeId(Utility.getUid());
	}
}
