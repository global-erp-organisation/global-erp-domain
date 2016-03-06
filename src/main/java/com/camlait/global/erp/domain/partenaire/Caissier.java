package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.caisse.Caisse;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper=true)
public class Caissier extends Employe {

	@ManyToOne
	@JoinColumn(name = "caisseId",updatable=false,insertable=false)
	private Caisse caisse;

	private String motDePasse;

	public Caissier() {
		setTypePartenaire(TypePartenaire.CAISSIER);
	}
}
