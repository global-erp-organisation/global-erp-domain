package com.camlait.global.erp.domain.document.stock.out;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-bon-de-sorties`")
public class BonDeSortie extends OutDocument {

    public BonDeSortie() {
        setDocumentType(DocumentType.BON_DE_SORTIE);
    }
}
