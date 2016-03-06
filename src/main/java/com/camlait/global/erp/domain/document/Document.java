package com.camlait.global.erp.domain.document;

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
import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.camlait.global.erp.domain.partenaire.Employe;
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
public class Document extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long documentId;

	@Column(name = "codeDocument", unique = true, nullable = false)
	private String codeDocument;

	private Date dateDocument;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsableDocument;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Enumerated(EnumType.STRING)
	private SensOperation sensOperation;

	@ManyToOne
	@JoinColumn(name = "bmqId")
	private Bmq bmq;

	@ManyToOne
	@JoinColumn(name = "inventaireId")
	private Inventaire inventaire;

	@OneToMany(mappedBy = "document")
	private Collection<LigneDeDocument> ligneDocuments;

	@Enumerated(EnumType.STRING)
	private TypeDocuments typeDocument;

	public Document() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Document(Long documentId, String codeDocument, Date dateDocument, Magasin magasin,
			Employe responsableDocument, Date dateDeCreation, Date derniereMiseAJour, SensOperation sensOperation,
			Bmq bmq, Inventaire inventaire, Collection<LigneDeDocument> ligneDocuments, TypeDocuments typeDocument) {
		super();
		this.documentId = documentId;
		this.codeDocument = codeDocument;
		this.dateDocument = dateDocument;
		this.magasin = magasin;
		this.responsableDocument = responsableDocument;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.sensOperation = sensOperation;
		this.bmq = bmq;
		this.inventaire = inventaire;
		this.ligneDocuments = ligneDocuments;
		this.typeDocument = typeDocument;
	}

}
