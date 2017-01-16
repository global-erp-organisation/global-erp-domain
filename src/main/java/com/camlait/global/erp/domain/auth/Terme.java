package com.camlait.global.erp.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
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
	
}
