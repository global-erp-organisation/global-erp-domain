package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.SensOperation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`op-manquant-financier-dus`")
public class ManquantFinancierDu extends ManquantFinancier {

    public ManquantFinancierDu(){
        setSensOperation(SensOperation.ENTREE);
    }
}
