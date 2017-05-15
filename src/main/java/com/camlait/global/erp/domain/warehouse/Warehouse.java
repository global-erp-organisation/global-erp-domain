package com.camlait.global.erp.domain.warehouse;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
import com.camlait.global.erp.domain.localization.Center;
import com.camlait.global.erp.domain.partner.Employee;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "centreId")
    private Center centre;

    @Transient
    private String workerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workerId")
    private Employee worker;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private Collection<Store> stores = Lists.newArrayList();

    public Warehouse() {
    }

    @PrePersist
    private void setKey() {
        setWarehouseId(EntityHelper.getUidFor(warehouseId));
    }

    @Override
    public Warehouse init() {
        setCentreId(centre == null ? null : centre.getLocalId());
        setWorkerId(worker == null ? null : worker.getPartnerId());
        setStores(stores == null ? Lists.newArrayList() : stores.stream().map(s -> {
            return s.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return OtherEnum.WAREHOUSE;
    }
}
