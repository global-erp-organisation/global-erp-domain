package com.camlait.global.erp.domain.document.commerciaux.vente;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.document.TypeDocumentVente;
import com.camlait.global.erp.domain.enumeration.document.TypeFacture;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;

@Entity
public class FactureClient extends DocumentDeVente {

	@OneToMany(mappedBy = "facture")
	private Collection<FactureReglement> factureReglements;

	@Enumerated(EnumType.STRING)
	private TypeFacture typeFacture;

	public Collection<FactureReglement> getFactureReglements() {
		return factureReglements;
	}

	public void setFactureReglements(Collection<FactureReglement> factureReglements) {
		this.factureReglements = factureReglements;
	}

	public TypeFacture getTypeFacture() {
		return typeFacture;
	}

	public void setTypeFacture(TypeFacture typeFacture) {
		this.typeFacture = typeFacture;
	}

	public FactureClient() {
		setTypeDocumentDeVente(TypeDocumentVente.FACTURE_CLIENT);
	}
}
