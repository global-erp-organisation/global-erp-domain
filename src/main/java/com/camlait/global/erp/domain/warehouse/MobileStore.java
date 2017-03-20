package com.camlait.global.erp.domain.warehouse;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.OtherEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`warehouse-store-mobiles`")
public class MobileStore extends Store {

    public MobileStore() {
        setStoreType(OtherEnum.MAGASIN_MOBILE);
    }
}
