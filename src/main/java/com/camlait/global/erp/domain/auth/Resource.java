package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"items", "resourceGroups", "resourceUsers"})
@ToString(exclude = {"items", "resourceGroups", "resourceUsers"})
@Builder
@AllArgsConstructor
@Table(name = "`auth-resources`")
public class Resource extends BaseEntity {

    @Id
    private String resourceId;

    @Transient
    private String parentResourceId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parentResourceId")
    private Resource parentResource;

    private String title;

    private String icon;

    private String sref;

    private String href;

    private Integer resourceOrder;

    @OneToMany(mappedBy = "parentResource")
    @Builder.Default private Collection<Resource> items = Lists.newArrayList();

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    @Builder.Default private Collection<ResourceGroup> resourceGroups = Lists.newArrayList();

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    @Builder.Default private Collection<ResourceUser> resourceUsers = Lists.newArrayList();

    public Resource() {
    }

    public Resource(String descriptionMenu) {
        this.title = descriptionMenu;
    }

    public Resource(String descriptionMenu, Resource menuParent) {
        super();
        this.title = descriptionMenu;
        this.parentResource = menuParent;
    }

    public void setRessourceParentId() {
        setParentResourceId(getParentResource().getResourceId());
    }

    public boolean hasDetails() {
        return (!this.getItems().isEmpty());
    }

    @PrePersist
    private void setKey() {
        setResourceId(EntityHelper.getUidFor(resourceId));
    }

    @Override
    public Resource init() {
        setParentResourceId(parentResource == null ? null : parentResource.getResourceId());
        setResourceGroups(resourceGroups == null ? Lists.newArrayList() : resourceGroups.stream().map(rg -> {
            return rg.init();
        }).collect(Collectors.toList()));
        setResourceUsers(resourceUsers == null ? Lists.newArrayList() : resourceUsers.stream().map(ru -> {
            return ru.init();
        }).collect(Collectors.toList()));
        setItems(items == null ? Lists.newArrayList() : items.stream().map(i -> {
            return i.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
