package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class MargeClientReglee extends MargeClient {

    public MargeClientReglee(){
        setSensOperation(SensOperation.SORTIE);
    }
}
