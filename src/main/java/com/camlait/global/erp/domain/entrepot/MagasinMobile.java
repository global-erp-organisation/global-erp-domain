package com.camlait.global.erp.domain.entrepot;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
public class MagasinMobile extends Magasin {
    
    public MagasinMobile() {
        setTypeMagasin(AutreEnum.MAGASIN_MOBILE);
    }
}
