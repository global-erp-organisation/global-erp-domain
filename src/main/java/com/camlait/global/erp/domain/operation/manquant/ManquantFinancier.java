package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ManquantFinancier extends Operation {

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="vendeurId")
	private Vendeur vendeur;
}
