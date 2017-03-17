package com.camlait.global.erp.domain.document.business.sale;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-bill-margins`")
public class MargingBill extends ClientBill {

    public MargingBill() {
        setDocumentType(DocumentType.FACTURE_MARGE);
    }
}