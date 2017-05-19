package com.camlait.global.erp.domain.document.stock.staging;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.stock.StockDocument;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.camlait.global.erp.domain.warehouse.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`doc-document-stagings`")
public class StagingDocument extends StockDocument {

	@Transient
	private String destinationStoreId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "destinationStoreId")
	private Store destinationStore;

	public StagingDocument() {
		setOperationDirection(OperationDirection.STAGING);
		setDocumentType(DocumentType.STAGING_DOCUMENT);
	}

	@Override
	public StagingDocument init() {
		setStoreId(getStore() == null ? null : getStore().getStoreId());
		setWorkerId(getDocumentWorker() == null ? null : getDocumentWorker().getPartnerId());
		setDmId(getDailyMovement() != null ? getDailyMovement().getDmId() : null);
		setInventoryId(getInventory() != null ? getInventory().getInventoryId() : null);
		setDestinationStoreId(destinationStore == null ? null : destinationStore.getStoreId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return DocumentType.STAGING_DOCUMENT;
	}
}
