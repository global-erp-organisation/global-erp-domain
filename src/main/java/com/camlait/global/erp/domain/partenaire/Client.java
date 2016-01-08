package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Client extends Partenaire {
    
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;
    
    @OneToMany(mappedBy = "client")
    private Collection<DocumentDeVente> documentDeVentes;
    
    private String description;
    
    private boolean clientAristourne;
    
    private double ristourne;
    
    public Zone getZone() {
        return zone;
    }
    
    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    public Collection<DocumentDeVente> getDocumentDeVentes() {
        return documentDeVentes;
    }
    
    public void setDocumentDeVentes(Collection<DocumentDeVente> documentDeVentes) {
        this.documentDeVentes = documentDeVentes;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isClientAristourne() {
        return clientAristourne;
    }
    
    public void setClientAristourne(boolean clientAristourne) {
        this.clientAristourne = clientAristourne;
    }
    
    public double getRistourne() {
        return ristourne;
    }
    
    public void setRistourne(double ristourne) {
        this.ristourne = ristourne;
    }
    
    public Client() {
        setTypePartenaire(TypePartenaire.CLIENT);
    }
    
}
