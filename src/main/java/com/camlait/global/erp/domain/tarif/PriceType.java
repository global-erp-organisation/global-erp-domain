package com.camlait.global.erp.domain.tarif;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "`tarif-price-types`")
public class PriceType extends BaseEntity {
    @Id
    private String priceTypeId;

    private String description;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    public PriceType() {
    }

    @PrePersist
    private void prePersist() {
        setPriceTypeId(Utility.getUidFor(priceTypeId));
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
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
