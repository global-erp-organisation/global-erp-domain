package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.manquant.ManquantFinancier;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Vendeur extends Employe {

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zoneDeVente;

	@OneToMany(mappedBy = "vendeur")
	private Collection<ManquantFinancier> manquantFinanciers;

	private boolean recoisDesCommission;

	private double tauxDeCommission;

	public Vendeur() {
		setTypePartenaire(TypePartenaire.VENDEUR);
	}
}
