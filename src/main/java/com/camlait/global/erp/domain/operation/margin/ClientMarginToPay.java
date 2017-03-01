package com.camlait.global.erp.domain.operation.margin;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.OperationDirection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-client-margin-to-pay`")
public class ClientMarginToPay extends ClientMargin {

    public ClientMarginToPay() {
        setOperationDirection(OperationDirection.IN);
    }
}
