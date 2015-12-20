package com.camlait.global.erp.domain.document.vente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.partenaire.Client;

@Entity
public class DocumentDeVente extends Document {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Client client;

    private boolean documentSolde;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isDocumentSolde() {
        return documentSolde;
    }

    public void setDocumentSolde(boolean documentSolde) {
        this.documentSolde = documentSolde;
    }

    public DocumentDeVente() {

    }
}
