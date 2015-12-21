package com.camlait.global.erp.domain.document.stock.sortie;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

public class DocumentDeSortie extends Document{

    public DocumentDeSortie(){
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.BON_SORTIE);
    }
}
