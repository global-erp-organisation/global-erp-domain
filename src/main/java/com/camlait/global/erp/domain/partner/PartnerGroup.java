package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

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
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Table(name = "`partenaire-groupe-partners`")
public class PartnerGroup extends BaseEntity {

    @Id
    private String partnerGroupId;

    private String partnerGroupDescription;

    @Builder.Default 
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
    public PartnerGroup init() {
        setPartners(partners == null ? Lists.newArrayList() : partners.stream().map(p -> {
            return p.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
