package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeDocumentSortie;

@Entity
public class BonDeSortie extends DocumentDeSortie {
    
    public BonDeSortie() {
        setTypeDocumentSortie(TypeDocumentSortie.BON_DE_SORTIE);
    }
}
