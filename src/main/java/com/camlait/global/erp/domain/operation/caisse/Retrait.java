package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.SensOperation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`op-retraits`")
public class Retrait extends OperationDeCaisse {

    public Retrait(){
        setSensOperation(SensOperation.SORTIE);
    }
}
