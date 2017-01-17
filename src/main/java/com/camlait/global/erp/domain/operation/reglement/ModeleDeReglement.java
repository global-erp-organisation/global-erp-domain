package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.ConditionReglement;
import com.camlait.global.erp.domain.enumeration.ModeleEvaluation;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.camlait.global.erp.domain.util.Utility;
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
	private String modeleId;

	@Enumerated(EnumType.ORDINAL)
	private ModeleEvaluation modeEvaluation;
	private double valeur;
	private int nombreDeJour;

	@Enumerated(EnumType.ORDINAL)
	private ConditionReglement conditionReglement;

	@Transient
	private String modeleDeReglementId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "modeleDeReglementId")
	private ModeDeReglement modeDeReglement;

	@Transient
	private String partenaireId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public ModeleDeReglement() {
		super();
	}
	
	@PrePersist
	private void setKey() {
		setModeleDeReglementId(Utility.getUid());
	}
}
