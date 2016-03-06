package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.partenaire.Partenaire;
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
public class PartenaireImmobilisation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientImmoId;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	@ManyToOne
	@JoinColumn(name = "immoId")
	private Immobilisation immobilisation;

	private Date dateAllocation;

	@Column(name = "actif")
	private boolean actif;

	private Date dateDeCreation;
	private Date derniereMiseAJour;

	public PartenaireImmobilisation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());

	}

	public PartenaireImmobilisation(Long clientImmoId, Partenaire partenaire, Immobilisation immobilisation,
			Date dateAllocation, boolean actif, Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.clientImmoId = clientImmoId;
		this.partenaire = partenaire;
		this.immobilisation = immobilisation;
		this.dateAllocation = dateAllocation;
		this.actif = actif;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
