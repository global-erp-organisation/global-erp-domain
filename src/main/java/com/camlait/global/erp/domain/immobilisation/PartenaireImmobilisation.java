package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.camlait.global.erp.domain.pk.PKPartenaireImmobilisation;

@Entity
public class PartenaireImmobilisation {

    @EmbeddedId
    private PKPartenaireImmobilisation clientImmoId;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
    private Partenaire partenaire;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.AUTO_ID,updatable=false,insertable=false)
    private Immobilisation immobilisation;

    @Column(name="dateAllocation",updatable=false,insertable=false)
    private DateTime dateAllocation;

    @Column(name="actif")
    private boolean actif;

    public PKPartenaireImmobilisation getClientImmoId() {
        return clientImmoId;
    }

    public void setClientImmoId(PKPartenaireImmobilisation clientImmoId) {
        this.clientImmoId = clientImmoId;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Immobilisation getImmobilisation() {
        return immobilisation;
    }

    public void setImmobilisation(Immobilisation immobilisation) {
        this.immobilisation = immobilisation;
    }

    public DateTime getDateAllocation() {
        return dateAllocation;
    }

    public void setDateAllocation(DateTime dateAllocation) {
        this.dateAllocation = dateAllocation;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientImmoId == null) ? 0 : clientImmoId.hashCode());
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
        PartenaireImmobilisation other = (PartenaireImmobilisation) obj;
        if (clientImmoId == null) {
            if (other.clientImmoId != null)
                return false;
        }
        else if (!clientImmoId.equals(other.clientImmoId))
            return false;
        return true;
    }

}
