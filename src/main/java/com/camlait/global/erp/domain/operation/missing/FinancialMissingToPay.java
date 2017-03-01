package com.camlait.global.erp.domain.operation.missing;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.OperationDirection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-financial-missing-to-pay`")
public class FinancialMissingToPay extends FinancialMissing {

    public FinancialMissingToPay() {
        setOperationDirection(OperationDirection.IN);
    }
}
