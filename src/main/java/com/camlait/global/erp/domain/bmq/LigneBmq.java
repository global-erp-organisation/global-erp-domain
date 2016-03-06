package com.camlait.global.erp.domain.bmq;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.produit.Produit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class LigneBmq extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneBmqId;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteLigne;

	private double prixUnitaireLigne;

	@ManyToOne
	@JoinColumn(name = "bmqId")
	private Bmq bmq;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@ManyToOne
	@JoinColumn(name = "documentId")
	private Document document;

	@OneToMany(mappedBy = "ligneBmq", cascade = CascadeType.ALL)
	private Collection<LigneBmqTaxe> ligneBmqTaxes;

	public LigneBmq() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public LigneBmq(Long ligneBmqId, Produit produit, Long quantiteLigne, double prixUnitaireLigne, Bmq bmq,
			Date dateDeCreation, Date derniereMiseAJour, Document document, Collection<LigneBmqTaxe> ligneBmqTaxes) {
		super();
		this.ligneBmqId = ligneBmqId;
		this.produit = produit;
		this.quantiteLigne = quantiteLigne;
		this.prixUnitaireLigne = prixUnitaireLigne;
		this.bmq = bmq;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.document = document;
		this.ligneBmqTaxes = ligneBmqTaxes;
	}
}
