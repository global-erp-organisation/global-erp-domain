package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends Partenaire {

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

	@OneToMany(mappedBy = "client")
	private Collection<DocumentDeVente> documentDeVentes;

	private String description;

	private boolean clientAristourne;

	private double ristourne;

	public Client() {
		setTypePartenaire(TypePartenaire.CLIENT);
	}

}
