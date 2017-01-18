package com.camlait.global.erp.domain.prix;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Builder
public class Tarif extends Entite {

	@Id
	private String tarifId;
	private String descriptionTarif;

	public Tarif() {
	}
	
	@PrePersist
	private void setKey() {
		setTarifId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
	}
}
