package com.camlait.global.erp.domain.document;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.produit.Produit;

@Entity
public class LigneDeDocument extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneDeDocumentId;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteLigne;

	private double prixunitaiteLigne;

	@ManyToOne
	@JoinColumn(name = "documentId")
	private Document document;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Column(name = "sensOperation")
	private SensOperation sensOperation;

	public Long getLigneDeDocumentId() {
		return ligneDeDocumentId;
	}

	public void setLigneDeDocumentId(Long ligneDeDocumentId) {
		this.ligneDeDocumentId = ligneDeDocumentId;
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

	public void setSensOperation(SensOperation sensOperation) {
		this.sensOperation = sensOperation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ligneDeDocumentId == null) ? 0 : ligneDeDocumentId.hashCode());
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
		if (ligneDeDocumentId == null) {
			if (other.ligneDeDocumentId != null)
				return false;
		} else if (!ligneDeDocumentId.equals(other.ligneDeDocumentId))
			return false;
		return true;
	}

	public LigneDeDocument() {
	}
}
