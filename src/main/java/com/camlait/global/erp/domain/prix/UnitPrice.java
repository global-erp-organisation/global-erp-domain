package com.camlait.global.erp.domain.prix;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
public class UnitPrice extends Entite {

	@Id
	private String unitPriceId;
	
	private Double value;

	@Transient
	private String produitId;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "produitId")
	private Produit produit;
	
	@Transient
	private String priceTypeId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "priceTypeId")
	private PriceType priceType;


	@Transient
	private String tarificationId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "tarificationId")
	private Tarification tarification;

	public UnitPrice() {
	}

	@Override
	public void postConstructOperation() {
		setProduitId(produit.getProduitId());
		setTarificationId(tarification.getTarificationId());
		setPriceTypeId(priceType.getPriceTypeId());
		
	}

	@PrePersist
	private void setKey() {
		setUnitPriceId(Utility.getUidFor(unitPriceId));
	}
}
