package com.camlait.global.erp.domain.document.stock.sortie;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;

public class DocumentDeSortie extends Document{

    public DocumentDeSortie(){
        setSensOperation(SensOperation.SORTIE);
    }
}
