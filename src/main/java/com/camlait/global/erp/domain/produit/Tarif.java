package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Tarif extends Entite {

	@Id
	private String tarifId;
	private String descriptionTarif;

	public Tarif(String descriptionTarif) {
		this.descriptionTarif = descriptionTarif;
	}

	public Tarif(String tarifId, String descriptionTarif) {
		super();
		this.tarifId = tarifId;
		this.descriptionTarif = descriptionTarif;
	}
	
	@PrePersist
	private void setKey() {
		setTarifId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
	}
}
