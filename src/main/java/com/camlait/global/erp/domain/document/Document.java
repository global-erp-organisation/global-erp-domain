package com.camlait.global.erp.domain.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.camlait.global.erp.domain.partenaire.Employe;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Document extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DocumentId;

    @Column(unique = true, nullable = false)
    private String codeDocument;

    private DateTime dateDocument;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.MAGASIN_ID)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Employe responsableDocument;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    private SensOperation sensOperation;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.BMQ_ID)
    private Bmq bmq;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.INVENTAIRE_ID)
    private Inventaire inventaire;

    public int getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(int documentId) {
        DocumentId = documentId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + DocumentId;
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
        if (DocumentId != other.DocumentId)
            return false;
        if (codeDocument == null) {
            if (other.codeDocument != null)
                return false;
        }
        else if (!codeDocument.equals(other.codeDocument))
            return false;
        return true;
    }

    public Document() {
        //
    }
}
