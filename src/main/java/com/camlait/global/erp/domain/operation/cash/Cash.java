package com.camlait.global.erp.domain.operation.cash;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.partner.Employee;
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
@Table(name = "`cash-cashes`")
public class Cash extends BaseEntity {
	@Id
	private String cashId;

	@Column(unique = true, nullable = false)
	private String cashCode;

	private String cashDescription;

	@Transient
	private String workerId;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "workerId")
	private Employee worker;

	public Cash() {
	}

	@PrePersist
	private void setKey() {
		setCashId(EntityHelper.getUidFor(cashId));
	}

	@Override
	public Cash init() {
		setWorkerId(worker == null ? null : worker.getPartnerId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		// TODO Auto-generated method stub
		return null;
	}
}
