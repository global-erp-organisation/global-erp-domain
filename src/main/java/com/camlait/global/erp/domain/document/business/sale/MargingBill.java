package com.camlait.global.erp.domain.document.business.sale;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-bill-margins`")
public class MargingBill extends ClientBill {

    public MargingBill() {
        setDocumentType(DocumentType.MARGIN_BILL);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.MARGIN_BILL;
    }
}
