package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partenaire-magasiniers`")
public class Magasinier extends Employe {

    @JsonManagedReference
    @OneToMany(mappedBy = "magasinierSortant")
    private Collection<Inventaire> inventaires = Sets.newHashSet();

    public Magasinier() {
        setTypePartenaire(TypePartenaire.MAGASINIER);
    }

}
