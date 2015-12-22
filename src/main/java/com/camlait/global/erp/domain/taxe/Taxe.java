package com.camlait.global.erp.domain.taxe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;

@Entity
public class Taxe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codeTaxe", unique = true, nullable = false)
	private String codeTaxe;

	@Column(name = "taxeDescription")
	private String taxeDescription;

	@Column(name = "valeurPourcentage")
	private double valeurPourcentage;

	@Column(name = "dateDeCreation")
	private DateTime dateDeCreation;

	@Column(name = "derniereMiseAJour")
	private DateTime derniereMiseAJour;

	public Long getTaxeId() {
		return id;
	}

	public void setTaxeId(Long taxeId) {
		this.id = taxeId;
	}

	public String getCodeTaxe() {
		return codeTaxe;
	}

	public void setCodeTaxe(String codeTaxe) {
		this.codeTaxe = codeTaxe;
	}

	public String getTaxeDescription() {
		return taxeDescription;
	}

	public void setTaxeDescription(String taxeDescription) {
		this.taxeDescription = taxeDescription;
	}

	public double getValeurPourcentage() {
		return valeurPourcentage;
	}

	public void setValeurPourcentage(double valeurPourcentage) {
		this.valeurPourcentage = valeurPourcentage;
	}

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	public Taxe(Long taxeId, String codeTaxe) {
		super();
		this.id = taxeId;
		this.codeTaxe = codeTaxe;
	}

	public Taxe() {
	}
}
