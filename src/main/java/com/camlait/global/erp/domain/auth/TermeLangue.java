package com.camlait.global.erp.domain.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class TermeLangue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long termeLangueId;
	
	@ManyToOne
	@JoinColumn(name="termeId")
	private Terme terme;
	
	@ManyToOne
	@JoinColumn(name="langueId")
	private Langue langue;

	private String value;
	
	public TermeLangue() {
		super();
	}

	public TermeLangue(Terme terme, Langue langue, String value) {
		super();
		this.terme = terme;
		this.langue = langue;
		this.value = value;
	}

	public TermeLangue(Long termeLangueId, Terme terme, Langue langue, String value) {
		super();
		this.termeLangueId = termeLangueId;
		this.terme = terme;
		this.langue = langue;
		this.value = value;
	}
	
}
