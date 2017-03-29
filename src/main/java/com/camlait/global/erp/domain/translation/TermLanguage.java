package com.camlait.global.erp.domain.translation;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.TermLanguageKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "`trans-term-languages`")
@IdClass(value = TermLanguageKey.class)
public class TermLanguage extends BaseEntity {

    @Transient
    private String termId;

    @Id
    @JsonBackReference(value="term")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "termId")
    private Term term;

    @Transient
    private String languageId;

    @Id
    @JsonBackReference(value="language")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "languageId")
    private Language language;

    private String translatedValue;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    public TermLanguage() {
        super();
    }

    public void setTermeId() {
        setTermId(getTerm().getTermId());
    }

    public void setLangueId() {
        setLanguageId(getLanguage().getLangId());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setLanguageId(language.getLangId());
        setTermId(term.getTermId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
