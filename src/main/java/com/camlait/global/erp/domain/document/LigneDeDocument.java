package com.camlait.global.erp.domain.document;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.pk.PKLigneDocument;
import com.camlait.global.erp.domain.produit.Produit;

@Entity
public class LigneDeDocument extends Entite {

	@EmbeddedId
	private PKLigneDocument ligneDocumentId;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Produit produit;

	@Column(name="quantiteLigne")
	private Long quantiteLigne;

	@Column(name="prixUnitaireLigne")
	private double prixunitaiteLigne;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Document document;

    @Column(name="dateDeCreation")
    private DateTime dateDeCreation;

    @Column(name="derniereMiseAJour")
    private DateTime derniereMiseAJour;

    @Column(name="sensOperation",updatable=false,insertable=false)
	private SensOperation sensOperation;

	public PKLigneDocument getLigneDocumentId() {
		return ligneDocumentId;
	}

	public void setLigneDocumentId(PKLigneDocument ligneDocumentId) {
		this.ligneDocumentId = ligneDocumentId;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Long getQuantiteLigne() {
		return quantiteLigne;
	}

	public void setQuantiteLigne(Long quantiteLigne) {
		this.quantiteLigne = quantiteLigne;
	}

	public double getPrixunitaiteLigne() {
		return prixunitaiteLigne;
	}

	public void setPrixunitaiteLigne(double prixunitaiteLigne) {
		this.prixunitaiteLigne = prixunitaiteLigne;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
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

	public void setSensOperation(SensOperation sensOperation) {
		this.sensOperation = sensOperation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ligneDocumentId == null) ? 0 : ligneDocumentId.hashCode());
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
		LigneDeDocument other = (LigneDeDocument) obj;
		if (ligneDocumentId == null) {
			if (other.ligneDocumentId != null)
				return false;
		} else if (!ligneDocumentId.equals(other.ligneDocumentId))
			return false;
		return true;
	}

	public LigneDeDocument() {
	}
}
