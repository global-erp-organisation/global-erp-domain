package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class Retrait extends OperationDeCaisse {

    public Retrait(){
        setSensOperation(SensOperation.SORTIE);
    }
}
