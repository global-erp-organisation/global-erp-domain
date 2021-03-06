package com.camlait.global.erp.domain.partner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.operation.cash.Cash;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@Table(name = "`partner-cahsiers`")
@EqualsAndHashCode(callSuper = true)
public class Cashier extends Employee {

	@Transient
	private String cashId;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "cashId", updatable = false, insertable = false)
	private Cash cash;

	private String motDePasse;

	public Cashier() {
		setPartnerType(PartnerType.CASHIER);
	}

	@Override
	public Cashier init() {
		setCenterId(getCentre() == null ? null : getCentre().getLocalId());
		setPartnerGroupId(getPartnerGroup() == null ? null : getPartnerGroup().getPartnerGroupId());
		setTarifId(getTarif() == null ? null : getTarif().getTarifId());
		setCashId(cash == null ? null : cash.getCashId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return PartnerType.CASHIER;
	}

}
