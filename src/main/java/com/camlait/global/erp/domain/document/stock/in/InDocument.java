package com.camlait.global.erp.domain.document.stock.in;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.stock.StockDocument;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;

@SuppressWarnings("serial")
@Entity
@Table(name = "`doc-document-ins`")
public class InDocument extends StockDocument {

    public InDocument() {
        setOperationDirection(OperationDirection.IN);
        setDocumentType(DocumentType.IN_DOCUMENT);
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.IN_DOCUMENT;
    }
}
