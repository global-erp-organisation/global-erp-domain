package com.camlait.global.erp.domain.operation.regulation.lettering;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.sale.ClientBill;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.BillRegulationKey;
import com.camlait.global.erp.domain.operation.regulation.Regulation;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "`reg-bill-regulations`")
@IdClass(value = BillRegulationKey.class)
public class BillRegulation extends BaseEntity {

    @Transient
    private String documentId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "documentId")
    private ClientBill bill;

    @Transient
    private String regulationId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "regulationId")
    private Regulation regulation;

    private Date distributionDate;

    private Double distributionValue;

    public BillRegulation() {
    }

    @Override
    public void postConstructOperation() {
        setDocumentId(bill.getDocumentId());
        setRegulationId(regulation.getOperationId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
