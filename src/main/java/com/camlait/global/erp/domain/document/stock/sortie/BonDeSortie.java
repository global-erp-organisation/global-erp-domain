package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`doc-bon-de-sorties`")
public class BonDeSortie extends DocumentDeSortie {
    
    public BonDeSortie() {
        setTypeDocument(TypeDocuments.BON_DE_SORTIE);
    }
}
