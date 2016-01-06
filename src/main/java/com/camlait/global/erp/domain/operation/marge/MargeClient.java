package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partenaire.ClientAmarge;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MargeClient extends Operation {

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="clientMargeId")
	private ClientAmarge client;
	
}
