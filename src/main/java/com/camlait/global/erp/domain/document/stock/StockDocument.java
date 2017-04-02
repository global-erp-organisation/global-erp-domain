package com.camlait.global.erp.domain.document.stock;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-stocks`")
public class StockDocument extends Document {

    public StockDocument() {
        setDocumentType(DocumentType.STOCK_DOCUMENT);
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.STOCK_DOCUMENT;
    }
}
