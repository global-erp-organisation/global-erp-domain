package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
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
public class Group extends Entite {

    @Id
    private String groupId;

    private String groupDescription;

    private Date createdDate;

    private Date lastUpdatedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private Collection<ResourceGroup> resourceGroups = Sets.newHashSet();

    @JsonManagedReference
    @ManyToMany(mappedBy = "groupes", cascade = CascadeType.ALL)
    private Collection<User> users = Sets.newHashSet();

    public Group() {
    }

    @PrePersist
    private void prePersist() {
        setGroupId(Utility.getUidFor(groupId));
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
}
