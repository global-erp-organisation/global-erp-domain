package com.camlait.global.erp.domain.document.commerciaux;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;

@Entity
public class ModeleDeTaxation extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long modeleDeTaxationId;

	private String descriptionModele;
	
	private Date dateDeCreation;
	private Date derniereMiseAJour;

	@OneToMany(mappedBy="modeleDeTaxation")
	private Collection<TaxeModele> taxeModeles;
	
	public Long getModeleDeTaxationId() {
		return modeleDeTaxationId;
	}

	public void setModeleDeTaxationId(Long modeleId) {
		this.modeleDeTaxationId = modeleId;
	}

	public String getDescriptionModele() {
		return descriptionModele;
	}

	public void setDescriptionModele(String descriptionModele) {
		this.descriptionModele = descriptionModele;
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

	public void setDerniereMiseAJour(Date derniereMiseAjour) {
		this.derniereMiseAJour = derniereMiseAjour;
	}

	public Collection<TaxeModele> getTaxeModeles() {
		return taxeModeles;
	}

	public void setTaxeModeles(Collection<TaxeModele> taxeModeles) {
		this.taxeModeles = taxeModeles;
	}

	public ModeleDeTaxation(){
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
