package com.camlait.global.erp.domain.document.stock.in;

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
@Table(name = "`doc-right-of-returns`")
public class ReturnItem extends InDocument {

    public ReturnItem() {
        setDocumentType(DocumentType.BON_DE_RETOUR);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.BON_DE_RETOUR;
    }
}
