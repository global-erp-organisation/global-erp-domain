package com.camlait.global.erp.domain.entrepot;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`ent-magasin-mobiles`")
public class MagasinMobile extends Magasin {
    
    public MagasinMobile() {
        setTypeMagasin(AutreEnum.MAGASIN_MOBILE);
    }
}
