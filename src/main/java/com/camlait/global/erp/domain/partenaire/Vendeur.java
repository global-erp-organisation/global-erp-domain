package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.immobilisation.PartenaireImmobilisation;
import com.camlait.global.erp.domain.localisation.Zone;

@Entity
public class Vendeur extends Employe {

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Zone zoneDeVente;

	@OneToMany(mappedBy = "immobilisation")
	private Collection<PartenaireImmobilisation> partenaireImmobilisations;

	public Zone getZoneDeVente() {
		return zoneDeVente;
	}

	public void setZoneDeVente(Zone zoneDeVente) {
		this.zoneDeVente = zoneDeVente;
	}

	public Collection<PartenaireImmobilisation> getPartenaireImmobilisations() {
		return partenaireImmobilisations;
	}

	public void setPartenaireImmobilisations(Collection<PartenaireImmobilisation> partenaireImmobilisations) {
		this.partenaireImmobilisations = partenaireImmobilisations;
	}

}
