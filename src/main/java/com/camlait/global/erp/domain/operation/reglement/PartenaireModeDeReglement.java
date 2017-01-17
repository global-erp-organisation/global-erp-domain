package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class PartenaireModeDeReglement extends Entite {

	@Id
	private String partenaireModeleId;

	@Transient
	private String modeleId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "modeleId")
	private ModeleDeReglement modeleDeReglement;

	@Transient
	private String partenaireId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public PartenaireModeDeReglement() {
		super();
	}
	
	@PrePersist
	private void setKey() {
		setPartenaireModeleId(Utility.getUid());
	}
}
