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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document extends Entite {

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

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public String getCodeDocument() {
		return codeDocument;
	}

	public void setCodeDocument(String codeDocument) {
		this.codeDocument = codeDocument;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Employe getResponsableDocument() {
		return responsableDocument;
	}

	public void setResponsableDocument(Employe responsableDocument) {
		this.responsableDocument = responsableDocument;
	}

	public Date getDateDocument() {
		return dateDocument;
	}

	public void setDateDocument(Date dateDocument) {
		this.dateDocument = dateDocument;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(Date derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	public SensOperation getSensOperation() {
		return sensOperation;
	}

	public Bmq getBmq() {
		return bmq;
	}

	public void setBmq(Bmq bmq) {
		this.bmq = bmq;
	}

	public void setSensOperation(SensOperation sensOperation) {
		this.sensOperation = sensOperation;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Collection<LigneDeDocument> getLigneDocuments() {
		return ligneDocuments;
	}

	public void setLigneDocuments(Collection<LigneDeDocument> ligneDocuments) {
		this.ligneDocuments = ligneDocuments;
	}

	public TypeDocuments getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(TypeDocuments typeDocument) {
		this.typeDocument = typeDocument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((codeDocument == null) ? 0 : codeDocument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (codeDocument == null) {
			if (other.codeDocument != null)
				return false;
		} else if (!codeDocument.equals(other.codeDocument))
			return false;
		return true;
	}

	public Document() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
