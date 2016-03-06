package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Partenaire;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class PartenaireModeDeReglement extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partenaireModeleId;

	@ManyToOne
	@JoinColumn(name = "modeleId")
	private ModeleDeReglement modeleDeReglement;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public PartenaireModeDeReglement() {
		super();
	}

	public PartenaireModeDeReglement(Long partenaireModeleId, ModeleDeReglement modeleDeReglement,
			Partenaire partenaire) {
		super();
		this.partenaireModeleId = partenaireModeleId;
		this.modeleDeReglement = modeleDeReglement;
		this.partenaire = partenaire;
	}

}
