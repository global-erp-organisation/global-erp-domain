package com.camlait.global.erp.domain.dm;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.keys.DailyMovmentDetailTaxKey;
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
@Table(name = "`dm-daily-movment-details-taxes`")
@IdClass(value=DailyMovmentDetailTaxKey.class)
public class DailyMovmentDetailTax extends Entite {
    @Transient
    private String dmdId;

    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dmdId")
    private DailyMovementDetail dailyMovementDetail;

    @Transient
    private String taxId;

    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxId")
    private Tax tax;

    private double taxRate;

    private Date createdDate;

    private Date lastUpdatedDate;

    public DailyMovmentDetailTax() {
    }

    public void setLigneBmqId() {
        setDmdId(getDailyMovementDetail().getDmdId());
    }

    public void setTaxeId() {
        setTaxId(getTax().getTaxId());
    }

    @Override
    public void postConstructOperation() {
        setDmdId(dailyMovementDetail.getDmdId());
        setTaxId(tax.getTaxId());
    }

    @PrePersist
    private void setKey() {
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

}