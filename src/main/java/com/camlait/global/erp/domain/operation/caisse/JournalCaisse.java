package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;

@Entity
public class JournalCaisse extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int journalId;

    @Column(unique = true, nullable = false)
    private String codeJournal;

    private String description;

    private DateTime dateDebutJournal;

    private DateTime dateFinJournal;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.CAISSE_ID)
    private Caisse caisse;

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + journalId;
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
        if (journalId != other.journalId)
            return false;
        return true;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }
}
