package com.camlait.global.erp.domain.document.stock.entree;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.SensOperation;

public class DocumentEntree extends Document {

    public DocumentEntree(){
        setSensOperation(SensOperation.ENTREE);
    }
}
