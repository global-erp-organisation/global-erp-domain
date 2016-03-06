package com.camlait.global.erp.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Terme {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long termeId;

	@Column(unique = true, nullable = false)
	private String descriptionTerme;

	public Terme(String descriptionTerme) {
		super();
		this.descriptionTerme = descriptionTerme;
	}

	public Terme() {
		super();
	}

	public Terme(Long termeId, String descriptionTerme) {
		super();
		this.termeId = termeId;
		this.descriptionTerme = descriptionTerme;
	}
	
	
}
