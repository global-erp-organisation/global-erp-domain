package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.manquant.ManquantFinancier;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vendeur extends Employe {
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "zoneId")
    private Zone zoneDeVente;
    
    @OneToMany(mappedBy = "vendeur")
    @JsonManagedReference
    private Collection<ManquantFinancier> manquantFinanciers;
    
    private boolean recoisDesCommission;
    
    private double tauxDeCommission;
    
    public Zone getZoneDeVente() {
        return zoneDeVente;
    }
    
    public void setZoneDeVente(Zone zoneDeVente) {
        this.zoneDeVente = zoneDeVente;
    }
    
    public Collection<ManquantFinancier> getManquantFinanciers() {
        return manquantFinanciers;
    }
    
    public void setManquantFinanciers(Collection<ManquantFinancier> manquantFinanciers) {
        this.manquantFinanciers = manquantFinanciers;
    }
    
    public boolean isRecoisDesCommission() {
        return recoisDesCommission;
    }
    
    public void setRecoisDesCommission(boolean recoisDesCommission) {
        this.recoisDesCommission = recoisDesCommission;
    }
    
    public double getTauxDeCommission() {
        return tauxDeCommission;
    }
    
    public void setTauxDeCommission(double tauxDeCommission) {
        this.tauxDeCommission = tauxDeCommission;
    }
    
    public Vendeur() {
        setTypePartenaire(TypePartenaire.VENDEUR);
    }
}
