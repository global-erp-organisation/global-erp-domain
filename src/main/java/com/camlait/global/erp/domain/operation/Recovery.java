package com.camlait.global.erp.domain.operation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.dm.DailyMovement;
import com.camlait.global.erp.domain.enumeration.OperationDirection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-recoveries`")
public class Recovery extends Operation {

	@Transient
	private String dmId;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "dmId")
	private DailyMovement dailyMovement;

	public Recovery() {
		setOperationDirection(OperationDirection.IN);
	}

	@Override
	public Recovery init() {
		setWorkerId(getWorker() == null ? null : getWorker().getPartnerId());
		setPartnerId(getPartner() == null ? null : getPartner().getPartnerId());
		setDmId(dailyMovement != null ? dailyMovement.getDmId() : null);
		return this;
	}
}
