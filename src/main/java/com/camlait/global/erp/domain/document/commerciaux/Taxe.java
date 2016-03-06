package com.camlait.global.erp.domain.document.commerciaux;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Taxe extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taxeId;

	@Column(name = "codeTaxe", unique = true, nullable = false)
	private String codeTaxe;

	private String taxeDescription;

	private double valeurPourcentage;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

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

	public Long getTaxeId() {
		return taxeId;
	}

	public void setTaxeId(Long taxeId) {
		this.taxeId = taxeId;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(Date derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	public Taxe(Long taxeId, String codeTaxe) {
		super();
		this.taxeId = taxeId;
		this.codeTaxe = codeTaxe;
	}

	public Taxe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Taxe(Long taxeId, String codeTaxe, String taxeDescription, double valeurPourcentage, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.taxeId = taxeId;
		this.codeTaxe = codeTaxe;
		this.taxeDescription = taxeDescription;
		this.valeurPourcentage = valeurPourcentage;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
