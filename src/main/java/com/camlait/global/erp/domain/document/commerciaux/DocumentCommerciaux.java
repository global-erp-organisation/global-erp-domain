package com.camlait.global.erp.domain.document.commerciaux;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class DocumentCommerciaux extends Document {
    
    public DocumentCommerciaux() {
        setTypeDocument(TypeDocuments.DOCUMENT_COMMERCIAUX);
    }
}
