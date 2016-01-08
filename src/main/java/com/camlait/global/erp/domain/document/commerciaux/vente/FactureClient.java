package com.camlait.global.erp.domain.document.commerciaux.vente;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class FactureClient extends DocumentDeVente {

	@OneToMany(mappedBy = "facture")
	private Collection<FactureReglement> factureReglements;

	public Collection<FactureReglement> getFactureReglements() {
		return factureReglements;
	}

	public void setFactureReglements(Collection<FactureReglement> factureReglements) {
		this.factureReglements = factureReglements;
	}


	public FactureClient() {
		setTypeDocument(TypeDocuments.FACTURE_CLIENT);
	}
}
