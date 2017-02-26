package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.operation.reglement.Reglement;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class FactureReglementKey implements Serializable {
  
    private FactureClient facture;
    private Reglement reglement;

    public FactureReglementKey() {
    }
}
