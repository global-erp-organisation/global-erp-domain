package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.document.DocumentDetails;
import com.camlait.global.erp.domain.document.business.Tax;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class DocumentDetailsTaxKey implements Serializable {
    private DocumentDetails documentDetails;
    private Tax tax;
}
