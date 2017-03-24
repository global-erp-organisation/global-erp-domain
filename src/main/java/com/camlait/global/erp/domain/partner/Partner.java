package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.asset.PartnerAsset;
import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.regulation.RegulationModel;
import com.camlait.global.erp.domain.tarif.Tarif;
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
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "`partner-partners`")
public class Partner extends BaseEntity {

    @Id
    private String partnerId;

    @Column(name = "partnerCode", nullable = false, unique = true)
    private String partnerCode;

    @Column(length = 512)
    private String adress;

    private String phone;

    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @Enumerated(EnumType.STRING)
    private PartnerType partnerType;

    @Transient
    private String centreId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "centreId")
    private Centre centre;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private Collection<SaleDocument> documents = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "immobilisation")
    private Collection<PartnerAsset> partnerAssets = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "partenaire")
    private Collection<Operation> operations = Sets.newHashSet();

    @Transient
    private String groupePartenaireId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "groupePartenaireId")
    private PartnerGroup partnerGroup;

    @Transient
    private String tarifId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarifId")
    private Tarif tarif;

    @JsonManagedReference
    @OneToMany(mappedBy = "partenaire")
    private Collection<RegulationModel> regulationModels = Sets.newHashSet();

    public Partner() {
    }

    @PrePersist
    private void setKey() {
        setPartnerId(Utility.getUidFor(partnerId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setCentreId(centre.getLocalId());
        setGroupePartenaireId(partnerGroup.getPartnerGroupId());
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
