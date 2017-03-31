package com.camlait.global.erp.domain.auth;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.State;
import com.camlait.global.erp.domain.keys.ResourceGroupKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "`auth-resource-groups`")
@IdClass(value = ResourceGroupKey.class)
public class ResourceGroup extends BaseEntity {

    @Transient
    private String groupId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @Transient
    private String resourceId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "resourceId")
    private Resource resource;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    public ResourceGroup() {
    }

    public void setRessourceId() {
        setResourceId(getResource().getResourceId());
    }

    @PrePersist
    private void prePersist(){
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }
    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
    }

    @Override
    public void postConstructOperation() {
        setGroupId(group.getGroupId());
        setResourceId(resource.getResourceId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
         return null;
    }
}
