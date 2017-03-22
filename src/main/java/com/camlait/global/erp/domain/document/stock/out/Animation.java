package com.camlait.global.erp.domain.document.stock.out;

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
@Table(name = "`doc-animations`")
public class Animation extends OutDocument {
    public Animation() {
        setDocumentType(DocumentType.ANIMATION);
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.ANIMATION;
    }
}
