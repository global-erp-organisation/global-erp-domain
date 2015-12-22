package com.camlait.global.erp.domain.localisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.vente.DocumentDeVente;
import com.camlait.global.erp.domain.partenaire.Client;

@Entity
public class Zone extends Localisation {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.LOCALISATION_ID,updatable=false,insertable=false)
    private Secteur secteur;

    @OneToMany(mappedBy = "zone")
    private Collection<DocumentDeVente> documents;

    @OneToMany(mappedBy = "zone")
    private Collection<Client> clients;

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Collection<DocumentDeVente> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<DocumentDeVente> documents) {
        this.documents = documents;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    public Zone() {

    }
}
