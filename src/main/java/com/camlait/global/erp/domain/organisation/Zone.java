package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.partenaire.Client;
import com.camlait.global.erp.domain.produit.Tarification;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Zone extends Localisation {

    @ManyToOne
    @JoinColumn(name = "secteurId")
    private Secteur secteur;

    @OneToMany(mappedBy = "zone")
    private Collection<DocumentDeVente> documents;

    @OneToMany(mappedBy = "zone")
    private Collection<Client> clients;

    @OneToMany(mappedBy="zone")
    private Collection<Tarification> tarifications;
    
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

    
    public Collection<Tarification> getTarifications() {
		return tarifications;
	}

	public void setTarifications(Collection<Tarification> tarifications) {
		this.tarifications = tarifications;
	}

	public Zone() {
        setTypeLocal(AutreEnum.ZONE);
    }
    
}
