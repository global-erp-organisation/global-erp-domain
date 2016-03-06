package com.camlait.global.erp.domain.operation.caisse;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;
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
public class Caisse extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caisseId;

	@Column(name = "codeCaisse", unique = true, nullable = false)
	private String codeCaisse;

	private String descriptionCaisse;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Caisse() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Caisse(Long caisseId, String codeCaisse, String descriptionCaisse, Employe responsable, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.caisseId = caisseId;
		this.codeCaisse = codeCaisse;
		this.descriptionCaisse = descriptionCaisse;
		this.responsable = responsable;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
