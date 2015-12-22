package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class DocumentEntree extends Document {
    
    public DocumentEntree() {
        setSensOperation(SensOperation.ENTREE);
        setTypeDocument(TypeDocuments.DOCUMENT_ENTREE);
    }
}
