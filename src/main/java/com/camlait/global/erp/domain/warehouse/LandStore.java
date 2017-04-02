package com.camlait.global.erp.domain.warehouse;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`warehouse-store-lands`")
public class LandStore extends Store {

    private String adresse;

    public LandStore() {
        setStoreType(OtherEnum.MOBILE_STORE);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return OtherEnum.MOBILE_STORE;
    }
}
