package com.camlait.global.erp.domain.operation.reglement;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.vente.FactureClient;
import com.camlait.global.erp.domain.operation.Operation;

@Entity
public class Reglement extends Operation {

    @OneToMany(mappedBy = "reglement")
    private Collection<FactureClient> factures;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.MODE_REGLEMENT_ID)
    private ModeDeReglement modeDeReglement;

    public Collection<FactureClient> getFactures() {
        return factures;
    }

    public void setFactures(Collection<FactureClient> factures) {
        this.factures = factures;
    }

    public ModeDeReglement getModeDeReglement() {
        return modeDeReglement;
    }

    public void setModeDeReglement(ModeDeReglement modeDeReglement) {
        this.modeDeReglement = modeDeReglement;
    }

}
