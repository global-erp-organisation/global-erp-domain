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
@Table(name = "`op-deposits`")
public class Deposit extends CashOperation {

    public Deposit() {
        setOperationDirection(OperationDirection.IN);
    }
}
