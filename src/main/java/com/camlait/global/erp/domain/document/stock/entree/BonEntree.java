package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.document.TypeDocumentEntree;

@Entity
public class BonEntree extends DocumentEntree {
	public BonEntree(){
		setTypeDocumentEntree(TypeDocumentEntree.BON_ENTREE);
	}
}
