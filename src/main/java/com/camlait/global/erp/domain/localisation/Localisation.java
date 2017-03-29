package com.camlait.global.erp.domain.localisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.OtherEnum;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "`loc-localisations`")
public  abstract class Localisation extends BaseEntity {

    @Id
    private String localId;

    @Column(nullable = false, unique = true)
    private String code;

    private String descriptionLocal;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @Enumerated(EnumType.STRING)
    private OtherEnum typeLocal;

    public Localisation() {
    }

    @PrePersist
    private void setKey() {
        setLocalId(Utility.getUidFor(localId));
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
