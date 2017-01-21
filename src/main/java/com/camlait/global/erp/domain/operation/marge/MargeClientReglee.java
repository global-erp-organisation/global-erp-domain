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
@Table(name="`op-marge-client-reglees`")
public class MargeClientReglee extends MargeClient {

    public MargeClientReglee(){
        setSensOperation(SensOperation.SORTIE);
    }
}
