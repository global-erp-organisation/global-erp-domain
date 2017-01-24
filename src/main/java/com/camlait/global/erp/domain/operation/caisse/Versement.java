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
@Table(name = "`op-versements`")
public class Versement extends OperationDeCaisse {

    public Versement() {
        setSensOperation(SensOperation.ENTREE);
    }
}
