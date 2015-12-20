package com.camlait.global.erp.domain.document.virement;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.enumeration.SensOperation;

public class DocumentVirement extends Document {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.MAGASIN_ID)
    private Magasin magasinDestination;

    public Magasin getMagasinDestination() {
        return magasinDestination;
    }

    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }

    public DocumentVirement() {
        setSensOperation(SensOperation.VIREMENT);
    }
}
