package com.camlait.global.erp.domain.operation.missing;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partner.Seller;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-financial-missings`")
public class FinancialMissingOperation extends Operation {

    @Transient
    private String sellerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sellerId")
    private Seller seller;

    public FinancialMissingOperation() {
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(getWorker().getPartnerId());
        setPartnerId(getPartner().getPartnerId());
        setSellerId(seller.getPartnerId());
    }
}
