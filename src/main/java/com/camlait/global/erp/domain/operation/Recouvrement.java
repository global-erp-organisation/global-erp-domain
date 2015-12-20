package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class Recouvrement extends Operation {

    @ManyToOne
    @JoinColumn(name = ClePrimaires.BMQ_ID)
    private Bmq bmq;

    public Recouvrement() {
        setSensOperation(SensOperation.ENTREE);
    }

}
