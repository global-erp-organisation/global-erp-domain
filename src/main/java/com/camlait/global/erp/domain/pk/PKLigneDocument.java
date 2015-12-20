package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKLigneDocument {

    private int documentId;

    private int produitId;

    private int sensOperation;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getSensOperation() {
        return sensOperation;
    }

    public void setSensOperation(int sensOperation) {
        this.sensOperation = sensOperation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + documentId;
        result = prime * result + produitId;
        result = prime * result + sensOperation;
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
        if (documentId != other.documentId)
            return false;
        if (produitId != other.produitId)
            return false;
        if (sensOperation != other.sensOperation)
            return false;
        return true;
    }    
}
