package com.camlait.global.erp.domain.operation.reglement;

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
public class ModeDeReglement extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long modeDeReglementId;

	@Column(name = "codeModeReglement", nullable = false, unique = true)
	private String codeModeReglement;

	private String descriptionModeReglement;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public ModeDeReglement() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public ModeDeReglement(Long modeDeReglementId, String codeModeReglement, String descriptionModeReglement,
			Date dateDeCreation, Date derniereMiseAJour) {
		super();
		this.modeDeReglementId = modeDeReglementId;
		this.codeModeReglement = codeModeReglement;
		this.descriptionModeReglement = descriptionModeReglement;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
