package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKLigneBmq {

    private int bmqId;

    private int produitId;

    private int documentId;

    public int getBmqId() {
        return bmqId;
    }

    public void setBmqId(int bmqId) {
        this.bmqId = bmqId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bmqId;
        result = prime * result + documentId;
        result = prime * result + produitId;
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
        PKLigneBmq other = (PKLigneBmq) obj;
        if (bmqId != other.bmqId)
            return false;
        if (documentId != other.documentId)
            return false;
        if (produitId != other.produitId)
            return false;
        return true;
    }   
}
