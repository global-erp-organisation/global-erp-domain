package com.camlait.global.erp.domain.bmq;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LigneBmqTaxe extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneBmqTaxeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ligneBmqId")
	private LigneBmq ligneBmq;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	private double tauxDeTaxe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public LigneBmqTaxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public LigneBmqTaxe(Long ligneBmqTaxeId, LigneBmq ligneBmq, Taxe taxe, double tauxDeTaxe, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.ligneBmqTaxeId = ligneBmqTaxeId;
		this.ligneBmq = ligneBmq;
		this.taxe = taxe;
		this.tauxDeTaxe = tauxDeTaxe;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
