package com.camlait.global.erp.domain.tarif;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Table(name = "`tarif-tarifs`")
public class Tariff extends BaseEntity {

    @Id
    private String tarifId;

    private String tariffDescription;

    public Tariff() {
    }

    @PrePersist
    private void setKey() {
        setTarifId(EntityHelper.getUidFor(tarifId));
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
