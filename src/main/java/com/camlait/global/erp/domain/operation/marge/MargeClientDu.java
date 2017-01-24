package com.camlait.global.erp.domain.operation.marge;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.SensOperation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-marge-client-dus`")
public class MargeClientDu extends MargeClient {

    public MargeClientDu() {
        setSensOperation(SensOperation.ENTREE);
    }
}
