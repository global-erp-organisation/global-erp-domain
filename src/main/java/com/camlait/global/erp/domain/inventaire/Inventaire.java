package com.camlait.global.erp.domain.inventaire;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.partenaire.Magasinier;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Inventaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long inventaireId;

	@Column(name = "codeInventaire", nullable = false, unique = true)
	private String codeInventaire;

	@Column(name = "dateInventaire", nullable = false)
	private Date dateInventaire;

	private String note;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = "magasinierSortantId")
	private Magasinier magasinierSortant;

	@ManyToOne
	@JoinColumn(name = "magasinierEntrantId")
	private Magasinier magasinierEntrant;

	private boolean inventaireClos;

	@OneToMany(mappedBy = "inventaire")
	private Collection<Document> documents;

	@OneToMany(mappedBy = "inventaire")
	private Collection<LigneInventaire> ligneInventaires;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Inventaire() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Inventaire(Long inventaireId, String codeInventaire, Date dateInventaire, String note, Magasin magasin,
			Magasinier magasinierSortant, Magasinier magasinierEntrant, boolean inventaireClos,
			Collection<Document> documents, Collection<LigneInventaire> ligneInventaires, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.inventaireId = inventaireId;
		this.codeInventaire = codeInventaire;
		this.dateInventaire = dateInventaire;
		this.note = note;
		this.magasin = magasin;
		this.magasinierSortant = magasinierSortant;
		this.magasinierEntrant = magasinierEntrant;
		this.inventaireClos = inventaireClos;
		this.documents = documents;
		this.ligneInventaires = ligneInventaires;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
