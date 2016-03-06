package com.camlait.global.erp.domain.operation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.partenaire.Partenaire;
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
public class Operation extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long operationId;

	private Date dateOperation;

	@Enumerated(EnumType.STRING)
	private SensOperation sensOperation;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String libelleOperation;

	private double montantOperation;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public Operation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Operation(Long operationId, Date dateOperation, SensOperation sensOperation, Date dateDeCreation,
			Date derniereMiseAJour, String libelleOperation, double montantOperation, Employe responsable,
			Partenaire partenaire) {
		super();
		this.operationId = operationId;
		this.dateOperation = dateOperation;
		this.sensOperation = sensOperation;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.libelleOperation = libelleOperation;
		this.montantOperation = montantOperation;
		this.responsable = responsable;
		this.partenaire = partenaire;
	}

}
