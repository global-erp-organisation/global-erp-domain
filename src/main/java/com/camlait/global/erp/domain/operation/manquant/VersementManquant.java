package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class VersementManquant extends ManquantFinancier {

    public VersementManquant(){
        setSensOperation(SensOperation.SORTIE);
    }
}
