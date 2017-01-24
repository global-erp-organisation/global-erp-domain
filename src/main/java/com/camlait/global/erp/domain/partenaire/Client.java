package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.localisation.Zone;
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
@Table(name = "`partenaire-clients`")
public class Client extends Partenaire {

    @Transient
    private String zoneId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private Collection<DocumentDeVente> documentDeVentes = Sets.newHashSet();

    private String description;

    private boolean clientAristourne;

    private double ristourne;

    public Client() {
        setTypePartenaire(TypePartenaire.CLIENT);
    }

    @Override
    public void postConstructOperation() {
        setCentreId(getCentre().getLocalId());
        setGroupePartenaireId(getGroupePartenaire().getGroupePartenaireId());
        setTarifId(getTarif().getTarifId());
        setZoneId(zone.getLocalId());
    }

    public Boolean isMarginClient() {
        return this instanceof ClientAmarge;
    }

    public Boolean isCashSalesClient() {
        return this instanceof ClientComptant;
    }
}
