package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.partenaire.Client;
import com.camlait.global.erp.domain.produit.Tarification;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Zone extends Localisation {

	@ManyToOne
	@JoinColumn(name = "secteurId")
	private Secteur secteur;

	@OneToMany(mappedBy = "zone")
	private Collection<DocumentDeVente> documents;

	@OneToMany(mappedBy = "zone")
	private Collection<Client> clients;

	@OneToMany(mappedBy = "zone")
	private Collection<Tarification> tarifications;

	public Zone() {
		setTypeLocal(AutreEnum.ZONE);
	}

}
