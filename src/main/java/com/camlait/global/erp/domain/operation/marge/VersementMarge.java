package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class VersementMarge extends MargeFinancier {

    public VersementMarge(){
        setSensOperation(SensOperation.SORTIE);
    }
}
