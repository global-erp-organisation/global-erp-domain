package com.camlait.global.erp.domain.operation.reglement;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Reglement extends Operation {

	@OneToMany(mappedBy = "reglement")
	@JsonManagedReference
	private Collection<FactureReglement> factureReglements;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "modeDeReglementId")
	private ModeDeReglement modeDeReglement;

	public Collection<FactureReglement> getFactureReglements() {
		return factureReglements;
	}

	public void setFactureReglements(Collection<FactureReglement> factureReglements) {
		this.factureReglements = factureReglements;
	}

	public ModeDeReglement getModeDeReglement() {
		return modeDeReglement;
	}

	public void setModeDeReglement(ModeDeReglement modeDeReglement) {
		this.modeDeReglement = modeDeReglement;
	}

}
