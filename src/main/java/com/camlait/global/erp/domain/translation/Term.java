package com.camlait.global.erp.domain.translation;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`trans-terms`")
public class Term extends Entite {

    @Id
    private String termId;

    @Column(unique = true, nullable = false)
    private String termDescription;

    private Date createdDate;
    private Date lastUpdateDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private Collection<TermLanguage> termLanguages = Sets.newHashSet();

    public Term() {
        super();
    }

    @PrePersist
    private void setKey() {
        setTermId(Utility.getUidFor(termId));
        setCreatedDate(new Date());
        setLastUpdateDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdateDate(new Date());
    }

    @Override
    public void postConstructOperation() {
    }

}
