package com.camlait.global.erp.domain.operation.reglement.lettrage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.operation.reglement.Reglement;
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
public class FactureReglement extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long factureReglementId;

	@ManyToOne
	@JoinColumn(name = "documentId")
	private FactureClient facture;

	@ManyToOne
	@JoinColumn(name = "reglementId")
	private Reglement reglement;

	private Date dateDeVentilation;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public FactureReglement() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public FactureReglement(Long factureReglementId, FactureClient facture, Reglement reglement, Date dateDeVentilation,
			Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.factureReglementId = factureReglementId;
		this.facture = facture;
		this.reglement = reglement;
		this.dateDeVentilation = dateDeVentilation;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}
	
}
