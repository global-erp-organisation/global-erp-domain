package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BonEntree extends DocumentEntree {
	public BonEntree(){
		setTypeDocument(TypeDocuments.BON_ENTREE);
	}
}
