package com.camlait.global.erp.domain.operation.caisse;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = "opreations")
@ToString(exclude = "opreations")
@Builder
@Table(name="`caisse-journal-caisses`")
public class JournalCaisse extends Entite {

	@Id
	private String journalId;

	@Column(name = "codeJournal", unique = true, nullable = false)
	private String codeJournal;

	private String description;

	private Date dateDebutJournal;

	private Date dateFinJournal;

	@Transient
	private String caisseId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "caisseId")
	private Caisse caisse;

	@JsonManagedReference
	@OneToMany(mappedBy = "journal")
	private Collection<OperationDeCaisse> opreations = Sets.newHashSet();

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public JournalCaisse() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PrePersist
	private void setKey() {
		setJournalId(Utility.getUidFor(journalId));
	}

	@Override
	public void postConstructOperation() {
		setCaisseId(caisse.getCaisseId());
	}
}
