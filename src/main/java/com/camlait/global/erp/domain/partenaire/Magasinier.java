package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Magasinier extends Employe {

    @JsonManagedReference
	@OneToMany(mappedBy="magasinierSortant")
    private Collection<Inventaire> inventaires = Lists.newArrayList();
    public Magasinier() {
    	setTypePartenaire(TypePartenaire.MAGASINIER);
    }

}
