package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.partenaire.Client;

@Entity
public class Immobilisation extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "codeImmo", nullable = false, unique = true)
    private String codeImmo;
    
    private Date dateAcquisition;
    
    private Date dateMiseEnService;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    @ManyToOne
    @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION, updatable = false, insertable = false)
    private Client client;
    
    public Long getImmoId() {
        return id;
    }
    
    public void setImmoId(Long immoId) {
        this.id = immoId;
    }
    
    public String getCodeImmo() {
        return codeImmo;
    }
    
    public void setCodeImmo(String codeImmo) {
        this.codeImmo = codeImmo;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDateAcquisition() {
        return dateAcquisition;
    }
    
    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }
    
    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }
    
    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }
    
    public Date getDateDeCreation() {
        return dateDeCreation;
    }
    
    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
    
    public Date getDerniereMiseAJour() {
        return derniereMiseAJour;
    }
    
    public void setDerniereMiseAJour(Date derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeImmo == null) ? 0 : codeImmo.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Immobilisation other = (Immobilisation) obj;
        if (codeImmo == null) {
            if (other.codeImmo != null)
                return false;
        } else if (!codeImmo.equals(other.codeImmo))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public Immobilisation() {
    
    }
    
}
