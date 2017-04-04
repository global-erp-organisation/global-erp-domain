package com.camlait.global.erp.domain.asset;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.PartnerAssetKey;
import com.camlait.global.erp.domain.partner.Partner;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`asset-partner-assets`")
@IdClass(value = PartnerAssetKey.class)
public class PartnerAsset extends BaseEntity {

    @Transient
    private String partnerId;

    @Id
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "partenaireId")
    private Partner partner;

    @Transient
    private String immoId;

    @Id
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "assetId")
    private Asset asset;

    private Date allocationDate;

    private boolean active;

    public PartnerAsset() {
    }

    @Override
    public void postConstructOperation() {
        setPartnerId(partner.getPartnerId());
        setImmoId(asset.getAssetId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
