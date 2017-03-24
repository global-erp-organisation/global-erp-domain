package com.camlait.global.erp.domain.tarif;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`tarif-unit-prices`")
@EqualsAndHashCode(callSuper = false)
public class UnitPrice extends BaseEntity {

    @Id
    private String unitPriceId;

    private Double value;

    @Transient
    private String productId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    @Transient
    private String priceTypeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "priceTypeId")
    private PriceType priceType;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarificationId")
    private Tarification tarification;

    private Date createdDate;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    public UnitPrice() {
    }

    @Override
    public void postConstructOperation() {
        setProductId(product.getProductId());
        setPriceTypeId(priceType.getPriceTypeId());

    }

    @PrePersist
    private void setKey() {
        setUnitPriceId(Utility.getUidFor(unitPriceId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }

}
