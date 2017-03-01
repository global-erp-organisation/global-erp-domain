package com.camlait.global.erp.domain.inventory;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.partner.StoreOperator;
import com.camlait.global.erp.domain.util.Utility;
import com.camlait.global.erp.domain.warehouse.Store;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"documents", "inventoryDetails"})
@ToString(exclude = {"documents", "inventoryDetails"})
@Builder
@Table(name = "`inv-inventories`")
public class Inventory extends Entite {

    @Id
    private String inventoryId;

    @Column(nullable = false, unique = true)
    private String inventoryCode;

    @Column(nullable = false)
    private Date inventoryDate;

    private String note;

    @Transient
    private String storeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Transient
    private String outgoingWarehouserId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "outgoingWarehouserId")
    private StoreOperator outgoingWarehouser;

    @Transient
    private String incomingWarehouserId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "incomingWarehouserId")
    private StoreOperator incomingWarehouser;

    private boolean closedInventory;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Collection<Document> documents = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Collection<InventoryDetail> inventoryDetails = Sets.newHashSet();

    private Date createdDate;

    private Date lastUpdatedDate;

    public Inventory() {
    }

    @PrePersist
    private void setKey() {
        setInventoryId(Utility.getUidFor(inventoryId));
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
        setIncomingWarehouserId(incomingWarehouser.getPartnerId());
        setOutgoingWarehouserId(outgoingWarehouser.getPartnerId());
    }
}
