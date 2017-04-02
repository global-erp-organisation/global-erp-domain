package com.camlait.global.erp.domain.partner;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.inventory.Inventory;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-store-operators`")
public class StoreOperator extends Employee {

    @JsonManagedReference
    @OneToMany(mappedBy = "outgoingWarehouser")
    private Collection<Inventory> inventories = Lists.newArrayList();

    public StoreOperator() {
        setPartnerType(PartnerType.STORE_OPERATOR);
    }

}
