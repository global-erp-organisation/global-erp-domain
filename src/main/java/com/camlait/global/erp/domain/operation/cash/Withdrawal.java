package com.camlait.global.erp.domain.operation.cash;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.OperationDirection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-withdarawals`")
public class Withdrawal extends CashOperation {

    public Withdrawal() {
        setOperationDirection(OperationDirection.OUT);
    }
}
