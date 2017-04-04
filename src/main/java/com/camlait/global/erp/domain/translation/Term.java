package com.camlait.global.erp.domain.translation;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

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
public class Term extends BaseEntity {

    @Id
    private String termId;

    @Column(unique = true, nullable = false)
    private String termDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private Collection<TermLanguage> termLanguages = Lists.newArrayList();

    public Term() {
        super();
    }

    @PrePersist
    private void setKey() {
        setTermId(EntityHelper.getUidFor(termId));
     }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }

}
