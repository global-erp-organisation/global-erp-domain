package com.camlait.global.erp.domain.document.vente;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;

@Entity
public class FactureClient extends DocumentDeVente {

	@OneToMany(mappedBy = "facture")
	private Collection<FactureReglement> factureReglements;

	public Collection<FactureReglement> getFactureReglements() {
		return factureReglements;
	}

	public void setFactureReglements(Collection<FactureReglement> factureReglements) {
		this.factureReglements = factureReglements;
	}
}
