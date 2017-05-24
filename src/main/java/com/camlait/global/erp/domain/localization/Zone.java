package com.camlait.global.erp.domain.localization;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.camlait.global.erp.domain.partner.Client;
import com.camlait.global.erp.domain.tarif.Tariffication;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`loc-zones`")
public class Zone extends Localization {

    @Transient
    private String secteurId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "secteurId")
    private Sector secteur;

    @OneToMany(mappedBy = "zone")
    private Collection<SaleDocument> documents = Lists.newArrayList();

    @OneToMany(mappedBy = "zone")
    private Collection<Client> clients = Lists.newArrayList();

    @OneToMany(mappedBy = "zone")
    private Collection<Tariffication> tarifications = Lists.newArrayList();

    public Zone() {
        setTypeLocal(OtherEnum.ZONE);
    }

    @Override
    public Zone init() {
        setSecteurId(secteur == null ? null : secteur.getLocalId());
        setDocuments(documents == null ? Lists.newArrayList() : documents.stream().map(d -> {
            return d.init();
        }).collect(Collectors.toList()));
        setClients(clients == null ? Lists.newArrayList() : clients.stream().map(c -> {
            return c.init();
        }).collect(Collectors.toList()));
        setTarifications(tarifications == null ? Lists.newArrayList() : tarifications.stream().map(t -> {
            return t.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.ZONE;
    }

}
