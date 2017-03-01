package com.camlait.global.erp.domain.asset;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`asset-assets`")
@EqualsAndHashCode(callSuper = false)
@Builder
public class Asset extends Entite {

    @Id
    private String assetId;

    @Column(nullable = false, unique = true)
    private String assetCode;

    private Date acquiredDate;

    private Date commissioningDate;

    private Date createdDate;

    private Date lastUpdateddate;

    private String assetDescription;

    public Asset() {
    }

    @PrePersist
    private void setKey() {
        setAssetId(Utility.getUidFor(assetId));
        setCreatedDate(new Date());
        setLastUpdateddate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdateddate(new Date());
    }

    @Override
    public void postConstructOperation() {
    }
}
