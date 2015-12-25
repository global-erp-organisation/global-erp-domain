package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.immobilisation.PartenaireImmobilisation;
import com.camlait.global.erp.domain.localisation.Zone;

@Entity
public class Client extends Partenaire {

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

	@OneToMany(mappedBy = "client")
	private Collection<DocumentDeVente> documentDeVentes;

	@OneToMany(mappedBy = "immobilisation")
	private Collection<PartenaireImmobilisation> partenaireImmobilisations;

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Collection<PartenaireImmobilisation> getPartenaireImmobilisations() {
		return partenaireImmobilisations;
	}

	public void setPartenaireImmobilisations(Collection<PartenaireImmobilisation> partenaireImmobilisations) {
		this.partenaireImmobilisations = partenaireImmobilisations;
	}

	public Collection<DocumentDeVente> getDocumentDeVentes() {
		return documentDeVentes;
	}

	public void setDocumentDeVentes(Collection<DocumentDeVente> documentDeVentes) {
		this.documentDeVentes = documentDeVentes;
	}

}
