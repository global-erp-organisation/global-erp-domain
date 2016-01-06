package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.caisse.Caisse;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Caissier extends Employe {

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "caisseId",updatable=false,insertable=false)
	private Caisse caisse;

	private String motDePasse;

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Caissier() {
		setTypePartenaire(TypePartenaire.CAISSIER);
	}
}
