package com.camlait.global.erp.domain.partner;

import java.util.Collection;

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
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name = "`partenaire-groupe-partners`")
public class PartnerGroup extends BaseEntity {

    @Id
    private String partnerGroupId;

    private String partnerGroupDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "partnerGroup")
    private Collection<Partner> partners = Lists.newArrayList();


    public PartnerGroup() {
        super();
    }

    @PrePersist
    private void setKey() {
        setPartnerGroupId(EntityHelper.getUidFor(partnerGroupId));
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return null;
    }
}
