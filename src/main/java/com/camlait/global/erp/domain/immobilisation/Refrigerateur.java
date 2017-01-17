package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Refrigerateur extends Immobilisation {

	@Column(name = "numeroDeSerie")
	private String numeroDeSerie;
	
	private String marque;

	public Refrigerateur() {

	}
}
