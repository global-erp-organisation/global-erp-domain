package com.camlait.global.erp.domain.operation;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.partner.Partner;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`op-operations`")
public abstract class Operation extends BaseEntity {

    @Id
    private String operationId;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    private Date operationDate;

    @Enumerated(EnumType.STRING)
    private OperationDirection operationDirection;

    private String operationLabel;

    private double operationValue;

    @Transient
    private String workerId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "workerId")
    private Employee worker;

    @Transient
    private String partnerId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "partnerId")
    private Partner partner;

    public Operation() {
    }

    @PrePersist
    private void setKey() {
        setOperationId(EntityHelper.getUidFor(operationId));
    }

    @Override
    public Operation init() {
        setWorkerId(worker == null ? null : worker.getPartnerId());
        setPartnerId(partner == null ? null : partner.getPartnerId());
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
