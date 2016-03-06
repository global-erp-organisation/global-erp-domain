package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.camlait.global.erp.domain.Entite;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Tarif extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tarifId;
	private String descriptionTarif;

	public Tarif(String descriptionTarif) {
		this.descriptionTarif = descriptionTarif;
	}

	public Tarif(Long tarifId, String descriptionTarif) {
		super();
		this.tarifId = tarifId;
		this.descriptionTarif = descriptionTarif;
	}
	
	
}
