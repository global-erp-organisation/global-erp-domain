package com.camlait.global.erp.domain.operation.cash;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@Table(name = "`op-cash-operations`")
@EqualsAndHashCode(callSuper = true)
public class CashOperation extends Operation {

	@Transient
	private String journalId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "journalId")
	private CashJournal journal;

	public CashOperation() {
	}

	@Override
	public CashOperation init() {
		setWorkerId(getWorker() == null ? null : getWorker().getPartnerId());
		setPartnerId(getPartner() == null ? null : getPartner().getPartnerId());
		setJournalId(journal == null ? null : journal.getJournalId());
		return this;
	}
}
