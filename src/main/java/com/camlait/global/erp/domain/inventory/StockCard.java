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
import com.camlait.global.erp.domain.keys.StockCardKey;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.warehouse.Store;
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
@Table(name = "`inv-stock-cards`")
@IdClass(value = StockCardKey.class)
public class StockCard extends Entite {

    @Id
    private Date stockDate;

    @Transient
    private String storeId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Transient
    private String productId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Date createdDate;
    private Date lastUpdatedDate;

    public StockCard() {
        super();
    }

    @PrePersist
    private void setKey() {
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setStoreId(store.getStoreId());
        setProductId(product.getProductId());
    }
}