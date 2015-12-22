package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

@Entity
public class BonDeSortie extends DocumentDeSortie {
    
    public BonDeSortie() {
        setTypeDocument(TypeDocuments.BON_SORTIE);
    }
}
