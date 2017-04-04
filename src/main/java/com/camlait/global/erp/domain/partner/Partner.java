package com.camlait.global.erp.domain.partner;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.asset.PartnerAsset;
import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.localization.Center;
import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.regulation.RegulationModel;
import com.camlait.global.erp.domain.tarif.Tariff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`partner-partners`")
public abstract class Partner extends BaseEntity {

    @Id
    private String partnerId;

    @Column(name = "partnerCode", nullable = false, unique = true)
    private String partnerCode;

    @Column(length = 512)
    private String adress;

    private String phone;

    @Enumerated(EnumType.STRING)
    private PartnerType partnerType;

    @Transient
    private String centerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center centre;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private Collection<SaleDocument> documents = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "asset")
    private Collection<PartnerAsset> partnerAssets = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "partner")
    private Collection<Operation> operations = Lists.newArrayList();

    @Transient
    private String partnerGroupId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partnerGroupId")
    private PartnerGroup partnerGroup;

    @Transient
    private String tarifId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarifId")
    private Tariff tarif;

    @JsonManagedReference
    @OneToMany(mappedBy = "partner")
    private Collection<RegulationModel> regulationModels = Lists.newArrayList();

    public Partner() {
    }

    @PrePersist
    private void setKey() {
        setPartnerId(EntityHelper.getUidFor(partnerId));
    }

    @Override
    public void postConstructOperation() {
        setCenterId(centre.getLocalId());
        setPartnerGroupId(partnerGroup.getPartnerGroupId());
        setTarifId(tarif.getTarifId());
    }

    public Boolean isEmployee() {
        return this instanceof Employee;
    }

    public Boolean isClient() {
        return this instanceof Client;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
