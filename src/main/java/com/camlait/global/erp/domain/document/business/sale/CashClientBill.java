package com.camlait.global.erp.domain.document.business.sale;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.dm.DailyMovement;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.partner.CashClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-bill-client-cash`")
public class CashClientBill extends ClientBill {

    public CashClientBill() {
        setDocumentType(DocumentType.CASH_BILL);
    }

    public static Document createHeaderFromBmq(DailyMovement dailyMovement) {
        final CashClientBill f = new CashClientBill();
        f.setDailyMovement(dailyMovement);
        f.setClient(new CashClient());
        f.setDocumentDate(new Date());
        f.setStore(dailyMovement.getStore());
        f.setDocumentWorker(dailyMovement.getWorker());
        f.setZone(dailyMovement.getSeller().getSaleZone());
        return f;
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.CASH_BILL;
    }
}
