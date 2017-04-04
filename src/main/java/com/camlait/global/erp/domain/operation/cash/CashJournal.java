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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

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
public class CashJournal extends BaseEntity {

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
    private Collection<CashOperation> operations = Lists.newArrayList();

    public CashJournal() {
    }

    @PrePersist
    private void setKey() {
        setJournalId(EntityHelper.getUidFor(journalId));
    }


    @Override
    public void postConstructOperation() {
        setCashId(cash.getCashId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
