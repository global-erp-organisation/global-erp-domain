package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.localization.Zone;
import com.camlait.global.erp.domain.operation.missing.FinancialMissingOperation;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-sellers`")
public class Seller extends Employee {

	@Transient
	private String zoneId;

	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone saleZone;

	@OneToMany(mappedBy = "seller")
	private Collection<FinancialMissingOperation> financialMissings = Lists.newArrayList();

	private boolean commissionable;

	private double commissionRate;

	public Seller() {
		setPartnerType(PartnerType.SELLER);
	}

	@Override
	public Seller init() {
		setCenterId(getCentre() == null ? null : getCentre().getLocalId());
		setPartnerGroupId(getPartnerGroup() == null ? null : getPartnerGroup().getPartnerGroupId());
		setTarifId(getTarif() == null ? null : getTarif().getTarifId());
		setProfessionId(getProfession() == null ? null : getProfession().getProfessionId());
		setUserId(getUser() != null ? getUser().getUserId() : null);
		setZoneId(saleZone == null ? null : saleZone.getLocalId());
		setFinancialMissings(financialMissings.stream().map(fm -> {
			return fm.init();
		}).collect(Collectors.toList()));
		return this;
	}
}
