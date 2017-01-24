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
@Table(name = "`doc-bon-de-retours`")
public class BonDeRetour extends DocumentEntree {

    public BonDeRetour() {
        setTypeDocument(TypeDocuments.BON_DE_RETOUR);
    }
}
