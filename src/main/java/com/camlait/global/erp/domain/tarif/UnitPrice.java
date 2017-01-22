package com.camlait.global.erp.domain.tarif;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
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
@Table(name = "`tarif-unit-prices`")
@EqualsAndHashCode(callSuper = false)
public class UnitPrice extends Entite {

	@Id
	private String unitPriceId;

	private Double value;

	@Transient
	private String produitId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
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

	private Date dateDeCreation;
	private Date derniereMiseAJour;

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
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}

}
