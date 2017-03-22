package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.partner.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"employees", "resourceUsers"})
@ToString(exclude = {"employees", "resourceUsers"})
@Builder
@Table(name = "`auth-users`")
public class User extends BaseEntity {
    @Id
    private String userId;

    @Column(nullable = false)
    private String email;

    private String password;

    private Date createdDate;

    private Date lastUpdatedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Collection<Employee> employees = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Collection<ResourceUser> resourceUsers = Sets.newHashSet();

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`auth-groupe-users`")
    private Collection<Group> groups = Sets.newHashSet();

    public User() {
    }

    @Override
    public void postConstructOperation() {
        ressourceGroupCopy();
    }

    private void ressourceGroupCopy() {
        if (groups != null && !groups.isEmpty()) {
            groups.stream().forEach(g -> {
                Collection<ResourceUser> ru = g.getResourceGroups().stream().map(rg -> {
                    return ResourceUser.builder()
                            .state(rg.getState())
                            .resource(rg.getResource())
                            .resourceId(rg.getResourceId())
                            .user(this)
                            .userId(this.getUserId())
                            .build();
                }).collect(Collectors.toList());
                resourceUsers.addAll(ru);
            });
        }
    }

    @PrePersist
    private void prePersist() {
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return null;
    }
}
