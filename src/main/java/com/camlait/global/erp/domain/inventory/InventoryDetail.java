package com.camlait.global.erp.domain.inventory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
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
@IdClass(value=InventoryDetailKey.class)
public class InventoryDetail extends Entite {

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

    private Date createdDate;

    private Date lastUpdateddate;

    public InventoryDetail() {
    }

    @PrePersist
    private void setKey() {
        setCreatedDate(new Date());
        setLastUpdateddate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdateddate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setInventoryId(inventory.getInventoryId());
        setProductId(product.getProductId());
    }

}
