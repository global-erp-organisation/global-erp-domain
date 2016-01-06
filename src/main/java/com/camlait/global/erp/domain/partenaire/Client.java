package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.immobilisation.PartenaireImmobilisation;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client extends Partenaire {
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "zoneId")
    private Zone zone;
    
    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private Collection<DocumentDeVente> documentDeVentes;
    
    @OneToMany(mappedBy = "immobilisation")
    @JsonManagedReference
    private Collection<PartenaireImmobilisation> partenaireImmobilisations;
    
    private String description;
    
    public Zone getZone() {
        return zone;
    }
    
    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    public Collection<PartenaireImmobilisation> getPartenaireImmobilisations() {
        return partenaireImmobilisations;
    }
    
    public void setPartenaireImmobilisations(Collection<PartenaireImmobilisation> partenaireImmobilisations) {
        this.partenaireImmobilisations = partenaireImmobilisations;
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
    
    public Client() {
        setTypePartenaire(TypePartenaire.CLIENT);
    }
    
}
