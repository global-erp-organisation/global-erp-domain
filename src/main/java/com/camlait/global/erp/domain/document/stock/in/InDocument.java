package com.camlait.global.erp.domain.document.stock.in;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.stock.StockDocument;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.enumeration.DocumentType;

@SuppressWarnings("serial")
@Entity
@Table(name = "`doc-document-ins`")
public class InDocument extends StockDocument {

    public InDocument() {
        setOperationDirection(OperationDirection.IN);
        setDocumentType(DocumentType.DOCUMENT_ENTREE);
    }
}
