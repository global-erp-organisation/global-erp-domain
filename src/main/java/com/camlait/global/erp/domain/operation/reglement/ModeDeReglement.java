package com.camlait.global.erp.domain.operation.reglement;

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
public class ModeDeReglement extends Entite {

	@Id
	private String modeDeReglementId;

	@Column(name = "codeModeReglement", nullable = false, unique = true)
	private String codeModeReglement;

	private String descriptionModeReglement;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public ModeDeReglement() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	@PrePersist
	private void setKey() {
		setModeDeReglementId(Utility.getUid());
	}
}
