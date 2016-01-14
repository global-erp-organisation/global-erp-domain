package com.camlait.global.erp.domain.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class TermeLangue {

	@Id
	private Long termeLangueId;
	
	@ManyToOne
	@JoinColumn(name="termeId")
	private Terme terme;
	
	@ManyToOne
	@JoinColumn(name="langueId")
	private Langue langue;

	public Long getTermeLangueId() {
		return termeLangueId;
	}

	public void setTermeLangueId(Long termeLangueId) {
		this.termeLangueId = termeLangueId;
	}

	public Terme getTerme() {
		return terme;
	}

	public void setTerme(Terme terme) {
		this.terme = terme;
	}

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	public TermeLangue() {
		super();
	}	
}
