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
@Table(name = "`op-client-margin-paids`")
public class ClientMarginPaid extends ClientMargin {

    public ClientMarginPaid() {
        setOperationDirection(OperationDirection.OUT);
    }
}
