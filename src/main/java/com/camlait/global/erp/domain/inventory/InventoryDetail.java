package com.camlait.global.erp.domain.inventory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.InventoryDetailKey;
import com.camlait.global.erp.domain.product.Product;
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
@Table(name = "`inv-inventory-details`")
@IdClass(value = InventoryDetailKey.class)
public class InventoryDetail extends BaseEntity {

    @Transient
    private String inventoryId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;

    @Transient
    private String productId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Long realQuantity;

    private Long ajustQuantity;

    private double realUnitPrice;

    private double ajustUnitPrice;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    public InventoryDetail() {
    }

    @PrePersist
    private void prePersist() {
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setInventoryId(inventory.getInventoryId());
        setProductId(product.getProductId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

}
