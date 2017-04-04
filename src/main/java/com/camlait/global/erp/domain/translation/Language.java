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
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@EqualsAndHashCode(callSuper = false, exclude = "termLanguages")
@ToString(exclude = "termLanguages")
@Builder
@Table(name = "`trans-languages`")
public class Language extends BaseEntity {
    @Id
    private String langId;

    @Column(unique = true, nullable = false)
    private String codeLangue;

    private String title;

    private String alt;

    @JsonManagedReference
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private Collection<TermLanguage> termLanguages = Lists.newArrayList();

    public Language(String key, String title, String alt) {
        super();
        this.codeLangue = key;
        this.title = title;
        this.alt = alt;
    }

    public Language() {
    }

    @PrePersist
    private void setKey() {
        setLangId(EntityHelper.getUidFor(langId));
     }

    @Override
    public void postConstructOperation() {
        // TODO Auto-generated method stub
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }

}
