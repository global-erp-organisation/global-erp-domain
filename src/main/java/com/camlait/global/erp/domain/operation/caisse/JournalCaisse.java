package com.camlait.global.erp.domain.operation.caisse;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class JournalCaisse extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long journalId;

	@Column(name = "codeJournal", unique = true, nullable = false)
	private String codeJournal;

	private String description;

	private Date dateDebutJournal;

	private Date dateFinJournal;

	@ManyToOne
	@JoinColumn(name = "caisseId")
	private Caisse caisse;

	@OneToMany(mappedBy = "journal")
	private Collection<OperationDeCaisse> opreations;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public JournalCaisse() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public JournalCaisse(Long journalId, String codeJournal, String description, Date dateDebutJournal,
			Date dateFinJournal, Caisse caisse, Collection<OperationDeCaisse> opreations, Date dateDeCreation,
			Date derniereMiseAJour) {
		super();
		this.journalId = journalId;
		this.codeJournal = codeJournal;
		this.description = description;
		this.dateDebutJournal = dateDebutJournal;
		this.dateFinJournal = dateFinJournal;
		this.caisse = caisse;
		this.opreations = opreations;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
	}

}
