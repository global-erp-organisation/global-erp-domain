package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.partenaire.Client;
import com.camlait.global.erp.domain.produit.Tarification;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Zone extends Localisation {

    @Transient
    private Long secteurId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "secteurId")
    private Secteur secteur;

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<DocumentDeVente> documents = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<Client> clients = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<Tarification> tarifications = Sets.newHashSet();

    public Zone() {
        setTypeLocal(AutreEnum.ZONE);
    }

}
