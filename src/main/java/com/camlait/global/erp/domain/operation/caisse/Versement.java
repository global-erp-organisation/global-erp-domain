package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.SensOperation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Versement extends OperationDeCaisse {

    public Versement(){
        setSensOperation(SensOperation.ENTREE);
    }
}
