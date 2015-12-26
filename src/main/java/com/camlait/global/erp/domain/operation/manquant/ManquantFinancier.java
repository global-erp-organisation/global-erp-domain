package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partenaire.Vendeur;

@Entity
public class ManquantFinancier extends Operation {

	@ManyToOne
	@JoinColumn(name="vendeurId")
	private Vendeur vendeur;
}
