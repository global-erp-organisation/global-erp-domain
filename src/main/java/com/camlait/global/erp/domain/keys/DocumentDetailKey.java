package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Builder
@Data
@AllArgsConstructor
public class DocumentDetailKey implements Serializable {
    private Product product;
    private Document document;

    public DocumentDetailKey() {

    }
}
