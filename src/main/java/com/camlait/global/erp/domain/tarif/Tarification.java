package com.camlait.global.erp.domain.tarif;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.localisation.Zone;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name = "`tarif-tarifications`")
public class Tarification extends Entite {

    @Id
    private String tarificationId;

    @Transient
    private String zoneId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

    @Transient
    private String produitId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    @Transient
    private String tarifId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarifId")
    private Tarif tarif;

    @JsonManagedReference
    @OneToMany(mappedBy = "produit")
    private Collection<UnitPrice> unitPrices = Sets.newHashSet();

    private Date dateDeCreation;
    private Date derniereMiseAJour;

    public Tarification() {
    }

    @PrePersist
    private void setKey() {
        setTarificationId(Utility.getUidFor(tarificationId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setProduitId(produit.getProduitId());
        setZoneId(zone.getLocalId());
        setTarifId(tarif.getTarifId());
    }
}
