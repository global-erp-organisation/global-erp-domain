package com.camlait.global.erp.domain.document.stock.entree;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`doc-bon-entrees`")
public class BonEntree extends DocumentEntree {
	public BonEntree(){
		setTypeDocument(TypeDocuments.BON_ENTREE);
	}
}
