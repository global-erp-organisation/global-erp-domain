package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKLigneDocument {

	private Long documentId;

	private Long produitId;

	private Long sensOperation;

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	public Long getSensOperation() {
		return sensOperation;
	}

	public void setSensOperation(Long sensOperation) {
		this.sensOperation = sensOperation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((produitId == null) ? 0 : produitId.hashCode());
		result = prime * result + ((sensOperation == null) ? 0 : sensOperation.hashCode());
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
		PKLigneDocument other = (PKLigneDocument) obj;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (produitId == null) {
			if (other.produitId != null)
				return false;
		} else if (!produitId.equals(other.produitId))
			return false;
		if (sensOperation == null) {
			if (other.sensOperation != null)
				return false;
		} else if (!sensOperation.equals(other.sensOperation))
			return false;
		return true;
	}

}
