package com.camlait.global.erp.domain.taxe;

import java.util.Collection;

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

}
