package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class MargeDu extends MargeFinancier {

    public MargeDu() {
        setSensOperation(SensOperation.ENTREE);
    }
}
