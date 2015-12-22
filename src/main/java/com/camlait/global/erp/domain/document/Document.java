package com.camlait.global.erp.domain.document;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Document extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	@Column(name="codeDocument",unique = true, nullable = false)
	private String codeDocument;

	@Column(name="dateDocument")
	private DateTime dateDocument;

	@ManyToOne
	@JoinColumn(name =ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private Employe responsableDocument;

    @Column(name="dateDeCreation")
    private DateTime dateDeCreation;

    @Column(name="derniereMiseAJour")
    private DateTime derniereMiseAJour;

    @Column(name="sensOperation")
	private SensOperation sensOperation;

	@ManyToOne
	//@JoinColumns({ @JoinColumn(name = ClePrimaires.AUTO_ID), @JoinColumn(name = ClePrimaires.AUTO_ID), @JoinColumn(name = "dateBmq") })
	@JoinColumn(name=ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private Bmq bmq;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
	private Inventaire inventaire;

	@OneToMany(mappedBy = "document")
	private Collection<LigneDeDocument> ligneDocuments;

	@Column(name="typeDocument")
	private TypeDocuments typeDocument;

	public Long getDocumentId() {
		return id;
	}

	public void setDocumentId(Long documentId) {
		this.id = documentId;
	}

	public String getCodeDocument() {
		return codeDocument;
	}

	public void setCodeDocument(String codeDocument) {
		this.codeDocument = codeDocument;
	}

	public DateTime getDateDocument() {
		return dateDocument;
	}

	public void setDateDocument(DateTime dateDocument) {
		this.dateDocument = dateDocument;
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

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (codeDocument == null) {
			if (other.codeDocument != null)
				return false;
		} else if (!codeDocument.equals(other.codeDocument))
			return false;
		return true;
	}

	public Document() {
		//
	}
}
