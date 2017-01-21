package com.camlait.global.erp.domain.localisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.partenaire.Client;
import com.camlait.global.erp.domain.tarif.Tarification;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="`loc-zones`")
public class Zone extends Localisation {

    @Transient
    private String secteurId;

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
    
	@Override
	public void postConstructOperation() {
		setSecteurId(secteur.getLocalId());
	}

}