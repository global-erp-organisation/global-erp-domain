package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false, exclude = { "resourceGroups", "users" })
@ToString(exclude = { "resourceGroups", "users" })
@AllArgsConstructor
@Builder
@Table(name = "`auth-groups`")
public class Group extends BaseEntity {

	@Id
	private String groupId;

	private String groupDescription;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
	private Collection<ResourceGroup> resourceGroups = Lists.newArrayList();

	@ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
	private Collection<User> users = Lists.newArrayList();

	public Group() {
	}

	@PrePersist
	private void prePersist() {
		setGroupId(EntityHelper.getUidFor(groupId));
	}

	@Override
	public Group init() {
		setResourceGroups(resourceGroups.stream().map(rg -> {
			return rg.init();
		}).collect(Collectors.toList()));
		setUsers(users.stream().map(u -> {
			return u.init();
		}).collect(Collectors.toList()));
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
