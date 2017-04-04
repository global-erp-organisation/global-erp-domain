package com.camlait.global.erp.domain.partner;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

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
public class Profession extends BaseEntity {

    @Id
    private String professionId;

    @Column(unique = true, nullable = false)
    private String professionCode;
    private String professionDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "profession")
    private Collection<Employee> employees = Lists.newArrayList();

    public Profession() {
        super();
    }

    @PrePersist
    private void setKey() {
        setProfessionId(EntityHelper.getUidFor(professionId));
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

}
