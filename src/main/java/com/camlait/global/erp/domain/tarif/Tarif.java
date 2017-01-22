package com.camlait.global.erp.domain.tarif;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Table(name = "`tarif-tarifs`")
public class Tarif extends Entite {

	@Id
	private String tarifId;
	private String descriptionTarif;
	private Date dateDeCreation;
	private Date derniereMiseAJour;

	public Tarif() {
	}

	@PrePersist
	private void setKey() {
		setTarifId(Utility.getUidFor(tarifId));
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}

	@Override
	public void postConstructOperation() {
	}
}
