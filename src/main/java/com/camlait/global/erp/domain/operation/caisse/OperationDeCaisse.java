package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.operation.Operation;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class OperationDeCaisse extends Operation {

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "journalId")
	private JournalCaisse journal;

	public JournalCaisse getJournal() {
		return journal;
	}

	public void setJournal(JournalCaisse journal) {
		this.journal = journal;
	}
}
