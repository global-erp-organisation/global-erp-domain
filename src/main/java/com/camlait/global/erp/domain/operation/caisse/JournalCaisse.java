package com.camlait.global.erp.domain.operation.caisse;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;

@Entity
public class JournalCaisse extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codeJournal", unique = true, nullable = false)
	private String codeJournal;

	private String description;

	private DateTime dateDebutJournal;

	private DateTime dateFinJournal;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Caisse caisse;

	@OneToMany(mappedBy = "journal")
	private Collection<OperationDeCaisse> opreations;

	private DateTime dateDeCreation;

	private DateTime derniereMiseAJour;

	public Long getJournalId() {
		return id;
	}

	public void setJournalId(Long journalId) {
		this.id = journalId;
	}

	public String getCodeJournal() {
		return codeJournal;
	}

	public void setCodeJournal(String codeJournal) {
		this.codeJournal = codeJournal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getDateDebutJournal() {
		return dateDebutJournal;
	}

	public void setDateDebutJournal(DateTime dateDebutJournal) {
		this.dateDebutJournal = dateDebutJournal;
	}

	public DateTime getDateFinJournal() {
		return dateFinJournal;
	}

	public void setDateFinJournal(DateTime dateFinJournal) {
		this.dateFinJournal = dateFinJournal;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public Collection<OperationDeCaisse> getOpreations() {
		return opreations;
	}

	public void setOpreations(Collection<OperationDeCaisse> opreations) {
		this.opreations = opreations;
	}

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeJournal == null) ? 0 : codeJournal.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JournalCaisse other = (JournalCaisse) obj;
		if (codeJournal == null) {
			if (other.codeJournal != null)
				return false;
		} else if (!codeJournal.equals(other.codeJournal))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
}
