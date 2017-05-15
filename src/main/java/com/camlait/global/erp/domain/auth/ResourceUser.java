package com.camlait.global.erp.domain.auth;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.State;
import com.camlait.global.erp.domain.keys.ResourceUserKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`auth-resource-users`")
@IdClass(value = ResourceUserKey.class)
public class ResourceUser extends BaseEntity {

	@Transient
	private String userId;

	@Id
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Transient
	private String resourceId;

	@Id
	@ManyToOne
	@JoinColumn(name = "resourceId")
	private Resource resource;

	@Enumerated(EnumType.STRING)
	private State state;

	public ResourceUser(User user, Resource resource, State state) {
		super();
		this.user = user;
		this.resource = resource;
		this.state = state;
	}

	public ResourceUser() {
	}

	@Override
	public ResourceUser init() {
		setResourceId(resource == null ? null : resource.getResourceId());
		setUserId(user == null ? null : user.getUserId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
