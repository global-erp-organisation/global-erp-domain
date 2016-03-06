package com.camlait.global.erp.domain.operation.reglement;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Reglement extends Operation {

	@OneToMany(mappedBy = "reglement")
	private Collection<FactureReglement> factureReglements;

	@ManyToOne
	@JoinColumn(name = "modeDeReglementId")
	private ModeDeReglement modeDeReglement;

}
