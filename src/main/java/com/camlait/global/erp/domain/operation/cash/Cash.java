package com.camlait.global.erp.domain.operation.cash;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`cash-cashes`")
public class Cash extends Entite {
    @Id
    private String cashId;

    @Column(unique = true, nullable = false)
    private String cashCode;

    private String cashDescription;

    @Transient
    private String workerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workerId")
    private Employee worker;

    private Date createdDate;

    private Date lastUpdatedDate;

    public Cash() {
    }

    @PrePersist
    private void setKey() {
        setCashId(Utility.getUidFor(cashId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(worker.getPartnerId());
    }
}