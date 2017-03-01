package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.document.business.sale.ClientBill;
import com.camlait.global.erp.domain.operation.regulation.Reglement;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BillRegulationKey implements Serializable {
  
    private ClientBill bill;
    private Reglement regulation;

    public BillRegulationKey() {
    }
}
