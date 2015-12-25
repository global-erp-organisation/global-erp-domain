package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class ManquantFinancierDu extends ManquantFinancier {

    public ManquantFinancierDu(){
        setSensOperation(SensOperation.ENTREE);
    }
}
