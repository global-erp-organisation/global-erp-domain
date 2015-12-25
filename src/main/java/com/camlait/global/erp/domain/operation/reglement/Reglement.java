package com.camlait.global.erp.domain.operation.reglement;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;

@Entity
public class Reglement extends Operation {

	@OneToMany(mappedBy = "reglement")
	private Collection<FactureReglement> factureReglements;

	@ManyToOne
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
