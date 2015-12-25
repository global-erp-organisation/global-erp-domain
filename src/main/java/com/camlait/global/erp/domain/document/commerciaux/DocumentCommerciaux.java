package com.camlait.global.erp.domain.document.commerciaux;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.taxe.ModeleDeTaxation;

@Entity
public class DocumentCommerciaux extends Document {

	@ManyToOne
	@JoinColumn(name = "modeleDeTaxationId")
	private ModeleDeTaxation modeleDeTaxation;

	public ModeleDeTaxation getModeleDeTaxation() {
		return modeleDeTaxation;
	}

	public void setModeleDeTaxation(ModeleDeTaxation modeleDeTaxation) {
		this.modeleDeTaxation = modeleDeTaxation;
	}

}
