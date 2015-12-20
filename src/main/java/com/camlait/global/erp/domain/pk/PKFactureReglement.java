package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKFactureReglement {

    private int reglementId;

    private int documentId;

    public int getReglementId() {
        return reglementId;
    }

    public void setReglementId(int reglementId) {
        this.reglementId = reglementId;
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
        result = prime * result + documentId;
        result = prime * result + reglementId;
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
        PKFactureReglement other = (PKFactureReglement) obj;
        if (documentId != other.documentId)
            return false;
        if (reglementId != other.reglementId)
            return false;
        return true;
    }

}
