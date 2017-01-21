package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.immobilisation.PartenaireImmobilisation;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.reglement.ModeleDeReglement;
import com.camlait.global.erp.domain.tarif.Tarif;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name="`partenaire-partenaires`")
public class Partenaire extends Entite {

	@Id
	private String partenaireId;

	@Column(name = "codePartenaire", nullable = false, unique = true)
	private String codePartenaire;

	@Column(length = 512)
	private String adresse;

	private String telephone;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Enumerated(EnumType.STRING)
	private TypePartenaire typePartenaire;

	@Transient
	private String centreId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private Collection<DocumentDeVente> documents = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "immobilisation")
	private Collection<PartenaireImmobilisation> partenaireImmobilisations = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "partenaire")
	private Collection<Operation> operations = Sets.newHashSet();

	@Transient
	private String groupePartenaireId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "groupePartenaireId")
	private GroupePartenaire groupePartenaire;

	@Transient
	private String tarifId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "tarifId")
	private Tarif tarif;

	@JsonManagedReference
	@OneToMany(mappedBy = "partenaire")
	private Collection<ModeleDeReglement> modeleDeReglements = Sets.newHashSet();

	public Partenaire() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PrePersist
	private void setKey() {
		setPartenaireId(Utility.getUidFor(partenaireId));
	}

	@Override
	public void postConstructOperation() {
		setCentreId(centre.getLocalId());
		setGroupePartenaireId(groupePartenaire.getGroupePartenaireId());
		setTarifId(tarif.getTarifId());
	}

	public Boolean isEmployee() {
		return this instanceof Employe;
	}

	public Boolean isClient() {
		return this instanceof Client;
	}
}
