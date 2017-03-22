package com.camlait.global.erp.domain.document.stock.out;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-echantillons`")
public class Echantillon extends OutDocument {

    public Echantillon() {
        setDocumentType(DocumentType.ECHANTILLON);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.ECHANTILLON;
    }
}
