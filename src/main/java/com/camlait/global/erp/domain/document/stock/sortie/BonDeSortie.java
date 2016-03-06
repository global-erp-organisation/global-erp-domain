package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BonDeSortie extends DocumentDeSortie {
    
    public BonDeSortie() {
        setTypeDocument(TypeDocuments.BON_DE_SORTIE);
    }
}
