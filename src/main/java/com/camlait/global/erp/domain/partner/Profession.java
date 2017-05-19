package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Profession extends BaseEntity {

    @Id
    private String professionId;

    @Column(unique = true, nullable = false)
    private String professionCode;
    private String professionDescription;

    @Builder.Default 
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
    public Profession init() {
        setEmployees(employees == null ? Lists.newArrayList() : employees.stream().map(e -> {
            return e.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

}
