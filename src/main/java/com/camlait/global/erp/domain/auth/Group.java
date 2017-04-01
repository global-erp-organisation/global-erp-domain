package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.util.EntityHelper;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

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

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @JsonManagedReference(value="group")
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Collection<ResourceGroup> resourceGroups = Sets.newHashSet();

    @JsonManagedReference(value="user-group")
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private Collection<User> users = Sets.newHashSet();

    public Group() {
    }

    @PrePersist
    private void prePersist() {
        setGroupId(EntityHelper.getUidFor(groupId));
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
         return null;
    }
}
