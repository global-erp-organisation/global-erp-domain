package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

@Embeddable
public class PKLigneInventaire {

    private int inventaireId;

    private int produitId;

    public int getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(int inventaireId) {
        this.inventaireId = inventaireId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + inventaireId;
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
        PKLigneInventaire other = (PKLigneInventaire) obj;
        if (inventaireId != other.inventaireId)
            return false;
        if (produitId != other.produitId)
            return false;
        return true;
    }

}
