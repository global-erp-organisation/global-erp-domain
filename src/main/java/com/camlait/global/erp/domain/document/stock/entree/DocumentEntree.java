package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@SuppressWarnings("serial")
@Entity
@Table(name = "`doc-document-entrees`")
public class DocumentEntree extends DocumentDeStock {

    public DocumentEntree() {
        setSensOperation(SensOperation.ENTREE);
        setTypeDocument(TypeDocuments.DOCUMENT_ENTREE);
    }
}
