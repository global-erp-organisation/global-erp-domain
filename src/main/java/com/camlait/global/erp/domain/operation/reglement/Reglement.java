package com.camlait.global.erp.domain.operation.reglement;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude = "factureReglements")
@ToString(exclude = "factureReglements")
public class Reglement extends Operation {

	@JsonManagedReference
	@OneToMany(mappedBy = "reglement")
	private Collection<FactureReglement> factureReglements = Sets.newHashSet();

	@Transient
	private String modeleDeReglementId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "modeDeReglementId")
	private ModeDeReglement modeDeReglement;

	public Reglement() {
	}

	@Override
	public void postConstructOperation() {
		setResponsableId(getResponsable().getPartenaireId());
		setPartenaireId(getPartenaire().getPartenaireId());
		setModeleDeReglementId(modeDeReglement.getModeDeReglementId());
	}
}
