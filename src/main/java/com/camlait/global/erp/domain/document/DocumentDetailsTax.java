package com.camlait.global.erp.domain.document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.DocumentDetailsTaxKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`doc-document-details-taxes`")
@IdClass(value = DocumentDetailsTaxKey.class)
public class DocumentDetailsTax extends BaseEntity {

	@Transient
	private String docDetailId;

	@Id
	@ManyToOne
	@JoinColumn(name = "docDetailId")
	private DocumentDetails documentDetails;

	@Transient
	private String taxId;

	@Id
	@ManyToOne
	@JoinColumn(name = "taxId")
	private Tax tax;

	private double taxRate;

	public DocumentDetailsTax() {
	}

	@Override
	public DocumentDetailsTax init() {
		setDocDetailId(documentDetails == null ? null : documentDetails.getDocDetailId());
		setTaxId(tax == null ? null : tax.getTaxId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
