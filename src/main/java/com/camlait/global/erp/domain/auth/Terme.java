package com.camlait.global.erp.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Terme {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long termeId;

	@Column(unique = true, nullable = false)
	private String descriptionTerme;

	public Long getTermeId() {
		return termeId;
	}

	public void setTermeId(Long termeId) {
		this.termeId = termeId;
	}

	public String getDescriptionTerme() {
		return descriptionTerme;
	}

	public void setDescriptionTerme(String descriptionTerme) {
		this.descriptionTerme = descriptionTerme;
	}

	public Terme(String descriptionTerme) {
		super();
		this.descriptionTerme = descriptionTerme;
	}

	public Terme() {
		super();
	}
}
