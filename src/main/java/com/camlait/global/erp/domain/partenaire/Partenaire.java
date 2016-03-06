package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.immobilisation.PartenaireImmobilisation;
import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.ModeleDeReglement;
import com.camlait.global.erp.domain.organisation.Centre;
import com.camlait.global.erp.domain.produit.Tarif;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public  class Partenaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partenaireId;

	@Column(name = "codePartenaire", nullable = false, unique = true)
	private String codePartenaire;

	@Column(length = 512)
	private String adresse;

	private String telephone;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Enumerated(EnumType.STRING)
	private TypePartenaire typePartenaire;

	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	@OneToMany(mappedBy = "client")
	private Collection<DocumentDeVente> documents;

	@OneToMany(mappedBy = "immobilisation")
	private Collection<PartenaireImmobilisation> partenaireImmobilisations;

	@OneToMany(mappedBy = "partenaire")
	private Collection<Operation> operations;

	@ManyToOne
	@JoinColumn(name = "groupePartenaireId")
	private GroupePartenaire groupePartenaire;

	@ManyToOne
	@JoinColumn(name = "tarifId")
	private Tarif tarif;

	@OneToMany(mappedBy = "partenaire")
	private Collection<ModeleDeReglement> modeleDeReglements;

	public Partenaire() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Partenaire(Long partenaireId, String codePartenaire, String adresse, String telephone, Date dateDeCreation,
			Date derniereMiseAJour, TypePartenaire typePartenaire, Centre centre, Collection<DocumentDeVente> documents,
			Collection<PartenaireImmobilisation> partenaireImmobilisations, Collection<Operation> operations,
			GroupePartenaire groupePartenaire, Tarif tarif, Collection<ModeleDeReglement> modeleDeReglements) {
		super();
		this.partenaireId = partenaireId;
		this.codePartenaire = codePartenaire;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.typePartenaire = typePartenaire;
		this.centre = centre;
		this.documents = documents;
		this.partenaireImmobilisations = partenaireImmobilisations;
		this.operations = operations;
		this.groupePartenaire = groupePartenaire;
		this.tarif = tarif;
		this.modeleDeReglements = modeleDeReglements;
	}
}
