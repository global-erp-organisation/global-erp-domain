package com.camlait.global.erp.domain.operation.cash;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@EqualsAndHashCode(callSuper = false, exclude = "operations")
@ToString(exclude = "operations")
@Builder
@Table(name = "`cash-journal-cashes`")
public class CashJournal extends Entite {

    @Id
    private String journalId;

    @Column( unique = true, nullable = false)
    private String journalCode;

    private String description;

    private Date startDate;

    private Date endDate;

    @Transient
    private String cashId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cashId")
    private Cash cash;

    @JsonManagedReference
    @OneToMany(mappedBy = "journal")
    private Collection<CashOperation> operations = Sets.newHashSet();

    private Date createdDate;

    private Date lastUpdatedDate;

    public CashJournal() {
    }

    @PrePersist
    private void setKey() {
        setJournalId(Utility.getUidFor(journalId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setCashId(cash.getCashId());
    }
}