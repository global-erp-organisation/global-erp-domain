package com.camlait.global.erp.domain.entrepot;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class MagasinFixe extends Magasin {
    
    private String adresse;
        
    public MagasinFixe(){
        setTypeMagasin(AutreEnum.MAGASIN_FIXE);
    }
}
