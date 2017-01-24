package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-de-sorties`")
public class DocumentDeSortie extends DocumentDeStock {

    public DocumentDeSortie() {
        setSensOperation(SensOperation.SORTIE);
        setTypeDocument(TypeDocuments.DOCUMENT_SORTIE);
    }
}
