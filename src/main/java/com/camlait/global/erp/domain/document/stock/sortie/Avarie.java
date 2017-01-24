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
@Table(name = "`doc-avaries`")
public class Avarie extends DocumentDeSortie {

    public Avarie() {
        setTypeDocument(TypeDocuments.AVARIE);
    }
}
