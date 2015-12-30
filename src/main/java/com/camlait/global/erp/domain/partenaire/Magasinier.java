package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.inventaire.Inventaire;

@Entity
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
