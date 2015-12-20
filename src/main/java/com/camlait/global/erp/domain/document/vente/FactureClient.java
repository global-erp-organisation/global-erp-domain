package com.camlait.global.erp.domain.document.vente;

import java.util.Collection;

import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.operation.reglement.Reglement;

public class FactureClient extends DocumentDeVente {

    @OneToMany(mappedBy = "facture")
    private Collection<Reglement> reglements;

    public Collection<Reglement> getReglements() {
        return reglements;
    }

    public void setReglements(Collection<Reglement> reglements) {
        this.reglements = reglements;
    }

}
