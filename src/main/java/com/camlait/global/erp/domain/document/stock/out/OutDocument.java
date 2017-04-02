package com.camlait.global.erp.domain.document.stock.out;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.stock.StockDocument;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-de-sorties`")
public class OutDocument extends StockDocument {

    public OutDocument() {
        setOperationDirection(OperationDirection.OUT);
        setDocumentType(DocumentType.OUT_DOCUMENT);
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.OUT_DOCUMENT;
    }
}
