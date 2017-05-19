package com.camlait.global.erp.domain.dm;

import javax.persistence.CascadeType;
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
import com.camlait.global.erp.domain.keys.DailyMovmentDetailTaxKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "`dm-daily-movment-details-taxes`")
@IdClass(value = DailyMovmentDetailTaxKey.class)
public class DailyMovmentDetailTax extends BaseEntity {
	@Transient
	private String dmdId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dmdId")
	private DailyMovementDetail dailyMovementDetail;

	@Transient
	private String taxId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taxId")
	private Tax tax;

	private double taxRate;

	public DailyMovmentDetailTax() {
	}

	public void setLigneBmqId() {
		setDmdId(getDailyMovementDetail().getDmdId());
	}

	public void setTaxeId() {
		setTaxId(getTax().getTaxId());
	}

	@Override
	public DailyMovmentDetailTax init() {
		setDmdId(dailyMovementDetail == null ? null : dailyMovementDetail.getDmdId());
		setTaxId(tax == null ? null : tax.getTaxId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
