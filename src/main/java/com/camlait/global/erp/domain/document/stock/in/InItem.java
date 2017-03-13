package com.camlait.global.erp.domain.document.stock.in;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-bon-entrees`")
public class InItem extends InDocument {
    public InItem() {
        setDocumentType(DocumentType.BON_ENTREE);
    }
}
