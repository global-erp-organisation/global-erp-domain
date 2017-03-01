package com.camlait.global.erp.domain.warehouse;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

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
        setStoreType(AutreEnum.MAGASIN_FIXE);
    }
}
