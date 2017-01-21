package com.camlait.global.erp.domain.auth.ressource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

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
public class Terme extends Entite{

	@Id
	private String termeId;

	@Column(unique = true, nullable = false)
	private String descriptionTerme;

	public Terme(String descriptionTerme) {
		super();
		this.descriptionTerme = descriptionTerme;
	}

	public Terme() {
		super();
	}	
	
	@PrePersist
	private void setKey() {
		setTermeId(Utility.getUidFor(termeId));
	}

	@Override
	public void postConstructOperation() {
	}

	
}
