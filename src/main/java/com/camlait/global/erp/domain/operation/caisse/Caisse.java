package com.camlait.global.erp.domain.operation.caisse;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
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

	@Transient
	private Long responsableId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Caisse() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
