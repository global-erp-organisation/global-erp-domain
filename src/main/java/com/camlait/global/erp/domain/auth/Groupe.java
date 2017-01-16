package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Groupe extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupeId;

    private String descriptionGroupe;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    @JsonManagedReference
    @OneToMany(mappedBy = "groupe")
    private Collection<GroupeUtilisateur> groupeUtilisateurs = Sets.newHashSet();

    public Groupe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
