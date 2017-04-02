package com.camlait.global.erp.domain.document.business.sale;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.localization.Zone;
import com.camlait.global.erp.domain.document.business.BusinessDocument;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.partner.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-sales`")
public class SaleDocument extends BusinessDocument {

    @Transient
    private String clientId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Transient
    private String zoneId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

    private boolean documentSolde;

    public SaleDocument() {
        setOperationDirection(OperationDirection.OUT);
        setDocumentType(DocumentType.SALE_DOCUMENT);
    }

    @Override
    public void postConstructOperation() {
        setStoreId(getStore().getStoreId());
        setWorkerId(getDocumentWorker().getPartnerId());
        setDmId(getDailyMovement() != null ? getDailyMovement().getDmId() : null);
        setInventoryId(getInventory() != null ? getInventory().getInventoryId() : null);
        setClientId(client.getPartnerId());
        setZoneId(zone.getLocalId());
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return DocumentType.SALE_DOCUMENT;
    }


}
