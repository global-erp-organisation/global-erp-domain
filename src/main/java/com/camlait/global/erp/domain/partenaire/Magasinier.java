package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Magasinier extends Employe {

	@OneToMany(mappedBy="magasinierSortant")
    private Collection<Inventaire> inventaires;
    public Magasinier() {
    	setTypePartenaire(TypePartenaire.MAGASINIER);
    }

}
