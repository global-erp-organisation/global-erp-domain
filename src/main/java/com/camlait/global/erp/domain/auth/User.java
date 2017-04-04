package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"resourceUsers"})
@ToString(exclude = {"resourceUsers"})
@Builder
@Table(name = "`auth-users`")
public class User extends BaseEntity {
    @Id
    private String userId;

    @Column(nullable = false)
    private String email;

    @Transient
    private String password;

    private String encryptPassword;

    @JsonManagedReference
    
    @OneToMany(mappedBy = "user")
    private Collection<ResourceUser> resourceUsers = Lists.newArrayList();

    @JsonBackReference
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`auth-groupe-users`", joinColumns = {@JoinColumn(name = "`group-id`")}, inverseJoinColumns = {@JoinColumn(name = "`user-id`")},
               uniqueConstraints = @UniqueConstraint(columnNames = {"`group-id`", "`user-id`"}))
    private Collection<Group> groups = Lists.newArrayList();

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
                    return ResourceUser.builder().state(rg.getState()).resource(rg.getResource()).resourceId(rg.getResourceId()).user(this)
                            .userId(this.getUserId()).build();
                }).collect(Collectors.toList());
                resourceUsers.addAll(ru);
            });
        }
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
