package com.camlait.global.erp.domain.document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.DocumentDetailsTaxKey;
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
@Table(name = "`doc-document-details-taxes`")
@IdClass(value = DocumentDetailsTaxKey.class)
public class DocumentDetailsTax extends BaseEntity {

    @Transient
    private String docDetailId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "docDetailId")
    private DocumentDetails documentDetails;

    @Transient
    private String taxId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "taxId")
    private Tax tax;

    private double taxRate;

    public DocumentDetailsTax() {
    }

    @Override
    public void postConstructOperation() {
        setDocDetailId(documentDetails.getDocDetailId());
        setTaxId(tax.getTaxId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
