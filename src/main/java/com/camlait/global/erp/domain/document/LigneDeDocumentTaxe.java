package com.camlait.global.erp.domain.document;

import java.util.Date;

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
public class LigneDeDocumentTaxe extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneDeDocumentTaxeId;

	@ManyToOne
	@JoinColumn(name = "ligneDeDocumentId")
	private LigneDeDocument ligneDeDocument;

	@ManyToOne
	@JoinColumn(name = "taxeId")
	private Taxe taxe;

	private double tauxDeTaxe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public LigneDeDocumentTaxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public LigneDeDocumentTaxe(Long ligneDeDocumentTaxeId, LigneDeDocument ligneDeDocument, Taxe taxe,
			double tauxDeTaxe, Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.ligneDeDocumentTaxeId = ligneDeDocumentTaxeId;
		this.ligneDeDocument = ligneDeDocument;
		this.taxe = taxe;
		this.tauxDeTaxe = tauxDeTaxe;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
