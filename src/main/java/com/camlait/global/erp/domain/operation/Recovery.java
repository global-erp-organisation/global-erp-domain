package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.dm.DailyMovement;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-recoveries`")
public class Recovery extends Operation {

    @Transient
    private String dmId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dmId")
    private DailyMovement dailyMovement;

    public Recovery() {
        setOperationDirection(OperationDirection.IN);
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(getWorker().getPartnerId());
        setPartnerId(getPartner().getPartnerId());
        setDmId(dailyMovement != null ? dailyMovement.getDmId() : null);
    }
}
