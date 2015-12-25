package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class MargeClientDu extends MargeClient {

    public MargeClientDu() {
        setSensOperation(SensOperation.ENTREE);
    }
}
