package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.manquant.ManquantFinancier;
import com.camlait.global.erp.domain.organisation.Zone;

@Entity
public class Vendeur extends Employe {

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zoneDeVente;

	@OneToMany(mappedBy = "vendeur")
	private Collection<ManquantFinancier> manquantFinanciers;

	public Zone getZoneDeVente() {
		return zoneDeVente;
	}

	public void setZoneDeVente(Zone zoneDeVente) {
		this.zoneDeVente = zoneDeVente;
	}

	public Collection<ManquantFinancier> getManquantFinanciers() {
		return manquantFinanciers;
	}

	public void setManquantFinanciers(Collection<ManquantFinancier> manquantFinanciers) {
		this.manquantFinanciers = manquantFinanciers;
	}

	public Vendeur() {
		setTypePartenaire(TypePartenaire.VENDEUR);
	}
}
