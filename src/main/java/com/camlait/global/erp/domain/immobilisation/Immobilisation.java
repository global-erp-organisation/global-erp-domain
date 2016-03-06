package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Immobilisation extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long immoId;

	@Column(name = "codeImmo", nullable = false, unique = true)
	private String codeImmo;

	private Date dateAcquisition;

	private Date dateMiseEnService;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String descriptionImmo;

	public Immobilisation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Immobilisation(Long immoId, String codeImmo, Date dateAcquisition, Date dateMiseEnService,
			Date dateDeCreation, Date derniereMiseAJour, String descriptionImmo) {
		super();
		this.immoId = immoId;
		this.codeImmo = codeImmo;
		this.dateAcquisition = dateAcquisition;
		this.dateMiseEnService = dateMiseEnService;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.descriptionImmo = descriptionImmo;
	}

}
