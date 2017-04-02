package com.camlait.global.erp.domain.localization;

import java.util.Collection;

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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`loc-zones`")
public class Zone extends Localization {

    @Transient
    private String secteurId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "secteurId")
    private Sector secteur;

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<SaleDocument> documents = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<Client> clients = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private Collection<Tariffication> tarifications = Lists.newArrayList();

    public Zone() {
        setTypeLocal(OtherEnum.ZONE);
    }

    @Override
    public void postConstructOperation() {
        setSecteurId(secteur.getLocalId());
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.ZONE;
    }

}
