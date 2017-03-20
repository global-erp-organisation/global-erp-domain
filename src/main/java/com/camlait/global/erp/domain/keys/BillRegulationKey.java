package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.document.business.sale.ClientBill;
import com.camlait.global.erp.domain.operation.regulation.Regulation;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BillRegulationKey implements Serializable {
  
    private ClientBill bill;
    private Regulation regulation;

    public BillRegulationKey() {
    }
}
