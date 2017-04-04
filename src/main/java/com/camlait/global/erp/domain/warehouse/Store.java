package com.camlait.global.erp.domain.warehouse;

import java.util.Collection;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.inventory.Stock;
import com.camlait.global.erp.domain.inventory.StockCard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"stockCards", "stocks"})
@ToString(exclude = {"stockCards", "stocks"})
@Builder
@Table(name = "`warehouse-store`")
public class Store extends BaseEntity {
    @Id
    private String storeId;

    @Column(unique = true, nullable = false)
    private String storeCode;

    private String storeDescription;

    @Transient
    private String warehouseId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouseId")
    private Warehouse warehouse;

    @Enumerated(EnumType.STRING)
    private OtherEnum storeType;

    @JsonManagedReference
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Collection<Stock> stocks = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Collection<StockCard> stockCards = Lists.newArrayList();

    public Store() {
    }

    @PrePersist
    private void setKey() {
        setStoreId(EntityHelper.getUidFor(storeId));
    }

    @Override
    public void postConstructOperation() {
        setWarehouseId(warehouse.getWarehouseId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
