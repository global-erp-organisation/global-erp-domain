package com.camlait.global.erp.domain.operation;

import java.util.Date;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.partner.Partner;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`op-operations`")
public abstract class Operation extends BaseEntity {

    @Id
    private String operationId;

    private Date operationDate;

    @Enumerated(EnumType.STRING)
    private OperationDirection operationDirection;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    private String operationLabel;

    private double operationValue;

    @Transient
    private String workerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workerId")
    private Employee worker;

    @Transient
    private String partnerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partnerId")
    private Partner partner;

    public Operation() {
    }

    @PrePersist
    private void setKey() {
        setOperationId(Utility.getUidFor(operationId));
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(worker.getPartnerId());
        setPartnerId(partner.getPartnerId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return null;
    }
}
