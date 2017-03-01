package com.camlait.global.erp.domain.operation.cash;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`op-cash-operations`")
@EqualsAndHashCode(callSuper = true)
public class CashOperation extends Operation {

    @Transient
    private String journalId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "journalId")
    private CashJournal journal;

    public CashOperation() {
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(getWorker().getPartnerId());
        setPartnerId(getPartner().getPartnerId());
        setJournalId(journal.getJournalId());
    }
}
