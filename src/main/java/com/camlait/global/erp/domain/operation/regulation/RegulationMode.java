package com.camlait.global.erp.domain.operation.regulation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
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
@Table(name = "`reg-regulation-modes`")
public abstract class RegulationMode extends BaseEntity {

    @Id
    private String regulationModeId;

    @Column( nullable = false, unique = true)
    private String regulationModeCode;

    private String regulationModeDescription;

    public RegulationMode() {
    }

    @PrePersist
    private void setKey() {
        setRegulationModeId(EntityHelper.getUidFor(regulationModeId));
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
