package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.inventory.Inventory;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-store-operators`")
public class StoreOperator extends Employee {

    @OneToMany(mappedBy = "outgoingWarehouser")
    private Collection<Inventory> inventories = Lists.newArrayList();

    public StoreOperator() {
        setPartnerType(PartnerType.STORE_OPERATOR);
    }

    @Override
    public StoreOperator init() {
        setInventories(inventories == null ? Lists.newArrayList() : inventories.stream().map(i -> {
            return i.init();
        }).collect(Collectors.toList()));
        return this;
    }

}
