package com.camlait.global.erp.domain.warehouse;

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

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.util.Utility;
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
@EqualsAndHashCode(callSuper = false, exclude = "stores")
@ToString(exclude = "stores")
@Builder
@Table(name = "`warehouse-warehouses`")
public class Warehouse extends BaseEntity {

    @Id
    private String warehouseId;

    @Column(nullable = false, unique = true)
    private String warehouseCode;

    private String warehouseDescription;

    @Transient
    private String centreId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "centreId")
    private Centre centre;

    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @Transient
    private String workerId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workerId")
    private Employee worker;

    @JsonManagedReference
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private Collection<Store> stores = Sets.newHashSet();

    public Warehouse() {
    }

    @PrePersist
    private void setKey() {
        setWarehouseId(Utility.getUidFor(warehouseId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setCentreId(centre.getLocalId());
        setWorkerId(worker.getPartnerId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.ENTREPOT;
    }
}
