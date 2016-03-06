package com.camlait.global.erp.domain.bmq;

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
import com.camlait.global.erp.domain.operation.Recouvrement;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Bmq extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bmqId;

	@Column(nullable = false, unique = true)
	private String codeBmq;

	private Date dateBmq;

	@ManyToOne
	@JoinColumn(name = "vendeurId")
	private Vendeur vendeur;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	@OneToMany(mappedBy = "bmq")
	private Collection<Document> documents;

	@OneToMany(mappedBy = "bmq")
	private Collection<Recouvrement> recouvrements;

	@OneToMany(mappedBy = "bmq")
	private Collection<LigneBmq> ligneBmqs;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private boolean bmqClos;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "responsableId")
	private Employe responsable;
	public Bmq() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	public Bmq(Long bmqId, String codeBmq, Date dateBmq, Vendeur vendeur, Magasin magasin,
			Collection<Document> documents, Collection<Recouvrement> recouvrements, Collection<LigneBmq> ligneBmqs,
			Date dateDeCreation, Date derniereMiseAJour, boolean bmqClos, Employe responsable) {
		super();
		this.bmqId = bmqId;
		this.codeBmq = codeBmq;
		this.dateBmq = dateBmq;
		this.vendeur = vendeur;
		this.magasin = magasin;
		this.documents = documents;
		this.recouvrements = recouvrements;
		this.ligneBmqs = ligneBmqs;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.bmqClos = bmqClos;
		this.responsable = responsable;
	}	
}
