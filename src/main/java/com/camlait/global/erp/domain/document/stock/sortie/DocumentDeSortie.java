package com.camlait.global.erp.domain.document.stock.sortie;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.document.stock.DocumentDeStock;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentDeSortie extends DocumentDeStock {

	public DocumentDeSortie() {
		setSensOperation(SensOperation.SORTIE);
		setTypeDocument(TypeDocuments.DOCUMENT_SORTIE);
	}
}
