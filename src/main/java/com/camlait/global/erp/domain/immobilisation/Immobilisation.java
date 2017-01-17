package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Immobilisation extends Entite {

	@Id
	private String immoId;

	@Column(name = "codeImmo", nullable = false, unique = true)
	private String codeImmo;

	private Date dateAcquisition;

	private Date dateMiseEnService;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String descriptionImmo;

	public Immobilisation() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	@PrePersist
	private void setKey() {
		setImmoId(Utility.getUid());
	}

}
