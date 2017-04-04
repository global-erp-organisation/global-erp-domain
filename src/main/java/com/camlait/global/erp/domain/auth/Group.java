package com.camlait.global.erp.domain.auth;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"resourceGroups", "users"})
@ToString(exclude = {"resourceGroups", "users"})
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name = "`auth-groups`")
public class Group extends BaseEntity {

    @Id
    private String groupId;

    private String groupDescription;

    @JsonManagedReference
    
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Collection<ResourceGroup> resourceGroups = Lists.newArrayList();

    @JsonManagedReference
    
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private Collection<User> users = Lists.newArrayList();

    public Group() {
    }

    @PrePersist
    private void prePersist() {
        setGroupId(EntityHelper.getUidFor(groupId));
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return null;
    }
}
