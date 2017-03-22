package com.camlait.global.erp.domain.operation.regulation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "`reg-regulation-modes`")
public class RegulationMode extends BaseEntity {

    @Id
    private String regulationModeId;

    @Column( nullable = false, unique = true)
    private String regulationModeCode;

    private String regulationModeDescription;

    private Date createdDate;

    private Date lastUpdatedDate;

    public RegulationMode() {
    }

    @PrePersist
    private void setKey() {
        setRegulationModeId(Utility.getUidFor(regulationModeId));
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
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
        // TODO Auto-generated method stub
        return null;
    }
}
