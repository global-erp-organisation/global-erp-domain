package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.dm.DailyMovementDetail;
import com.camlait.global.erp.domain.document.business.Tax;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class DailyMovmentDetailTaxKey implements Serializable {
    private DailyMovementDetail dailyMovementDetail;
    private Tax tax;
}
