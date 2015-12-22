package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class DocumentDeSortie extends Document {
    
    public DocumentDeSortie() {
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.BON_SORTIE);
    }
}
