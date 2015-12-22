package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.operation.caisse.Caisse;

@Entity
public class Caissier extends Employe {

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Caisse caisse;

	@Column(name = "motDePasse")
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

	}
}
