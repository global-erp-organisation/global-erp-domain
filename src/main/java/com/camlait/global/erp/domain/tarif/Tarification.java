package com.camlait.global.erp.domain.tarif;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.TarificationKey;
import com.camlait.global.erp.domain.localisation.Zone;
import com.camlait.global.erp.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
@IdClass(value = TarificationKey.class)
public class Tarification extends BaseEntity {
   
    @Transient
    private String zoneId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

    @Transient
    private String productId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Transient
    private String tarifId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarifId")
    private Tarif tarif;
    
    @Transient
    private String priceTypeId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "priceTypeId")
    private PriceType priceType;
    
    private Double value;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedate;

    public Tarification() {
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setProductId(product.getProductId());
        setZoneId(zone.getLocalId());
        setTarifId(tarif.getTarifId());
        setPriceTypeId(priceType.getPriceTypeId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
