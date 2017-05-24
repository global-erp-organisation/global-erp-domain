package com.camlait.global.erp.domain.operation.missing;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partner.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-financial-missings`")
public class FinancialMissingOperation extends Operation {

	@Transient
	private String sellerId;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "sellerId")
	private Seller seller;

	public FinancialMissingOperation() {
	}

	@Override
	public FinancialMissingOperation init() {
		setWorkerId(getWorker() == null ? null : getWorker().getPartnerId());
		setPartnerId(getPartner() == null ? null : getPartner().getPartnerId());
		setSellerId(seller == null ? null : seller.getPartnerId());
		return this;
	}
}
