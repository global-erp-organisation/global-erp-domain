package com.camlait.global.erp.domain.operation.reglement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.camlait.global.erp.domain.Entite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class ModeDeReglement extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long modeDeReglementId;

	@Column(name = "codeModeReglement", nullable = false, unique = true)
	private String codeModeReglement;

	private String descriptionModeReglement;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public ModeDeReglement() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
