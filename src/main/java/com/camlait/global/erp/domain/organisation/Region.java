package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
public class Region extends Localisation {

    @ManyToOne
    @JoinColumn(name = "centreId")
    private Centre centre;

    @OneToMany(mappedBy="region")
    private Collection<Secteur> secteurs;

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Collection<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(Collection<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public Region() {
        setTypeLocal(AutreEnum.REGION);
    }

}