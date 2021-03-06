package com.camlait.global.erp.domain.document.business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.tarif.PriceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-document-business`")
public class BusinessDocument extends Document {

	@Transient
	private String priceTypeId;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "priceTypeId")
	private PriceType priceType;

	public BusinessDocument() {
		setDocumentType(DocumentType.BUSINESS_DOCUMENT);
	}

	@Override
	public BusinessDocument init() {
		setStoreId(getStore() == null ? null : getStore().getStoreId());
		setWorkerId(getDocumentWorker() == null ? null : getDocumentWorker().getPartnerId());
		setDmId(getDailyMovement() != null ? getDailyMovement().getDmId() : null);
		setInventoryId(getInventory() != null ? getInventory().getInventoryId() : null);
		setPriceTypeId(priceType == null ? null : priceType.getPriceTypeId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return DocumentType.BUSINESS_DOCUMENT;
	}

}
