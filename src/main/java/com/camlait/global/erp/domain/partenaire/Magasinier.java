package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Magasinier extends Employe {

	@OneToMany(mappedBy="magasinierSortant")
    private Collection<Inventaire> inventaires;

    public Collection<Inventaire> getInventaires() {
        return inventaires;
    }

    public void setInventaires(Collection<Inventaire> inventaires) {
        this.inventaires = inventaires;
    }

    public Magasinier() {
    	setTypePartenaire(TypePartenaire.MAGASINIER);
    }

}
