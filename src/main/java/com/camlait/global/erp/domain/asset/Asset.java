package com.camlait.global.erp.domain.asset;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`asset-assets`")
@EqualsAndHashCode(callSuper = false)
public abstract class Asset extends BaseEntity {

    @Id
    private String assetId;

    @Column(nullable = false, unique = true)
    private String assetCode;

    private Date acquiredDate;

    private Date commissioningDate;

    private String assetDescription;

    public Asset() {
    }

    @PrePersist
    private void setKey() {
        setAssetId(EntityHelper.getUidFor(assetId));
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
