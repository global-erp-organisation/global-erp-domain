package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.ConditionReglement;
import com.camlait.global.erp.domain.enumeration.ModeleEvaluation;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class ModeleDeReglement extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long modeleId;

	@Enumerated(EnumType.ORDINAL)
	private ModeleEvaluation modeEvaluation;
	private double valeur;
	private int nombreDeJour;

	@Enumerated(EnumType.ORDINAL)
	private ConditionReglement conditionReglement;

	@Transient
	private Long modeleDeReglementId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "modeleDeReglementId")
	private ModeDeReglement modeDeReglement;

	@Transient
	private Long partenaireId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public ModeleDeReglement() {
		super();
	}
}
