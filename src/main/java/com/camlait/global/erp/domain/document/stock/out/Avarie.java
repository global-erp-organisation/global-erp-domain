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
@Table(name = "`doc-avaries`")
public class Avarie extends OutDocument {

    public Avarie() {
        setDocumentType(DocumentType.AVARIE);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.AVARIE;
    }
}
