package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKStock {

    private int produitId;

    private int magasinId;

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + magasinId;
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
        PKStock other = (PKStock) obj;
        if (magasinId != other.magasinId)
            return false;
        if (produitId != other.produitId)
            return false;
        return true;
    }
}
