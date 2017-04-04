package com.camlait.global.erp.domain.localization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.camlait.global.erp.domain.helper.EntityHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`loc-localizations`")
public  abstract class Localization extends BaseEntity {

    @Id
    private String localId;

    @Column(nullable = false, unique = true)
    private String code;

    private String descriptionLocal;

    @Enumerated(EnumType.STRING)
    private OtherEnum typeLocal;

    public Localization() {
    }

    @PrePersist
    private void setKey() {
        setLocalId(EntityHelper.getUidFor(localId));
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
