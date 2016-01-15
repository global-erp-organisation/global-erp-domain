package com.camlait.global.erp.domain.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
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
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TermeLangue() {
		super();
	}

	public TermeLangue(Terme terme, Langue langue, String value) {
		super();
		this.terme = terme;
		this.langue = langue;
		this.value = value;
	}		
}
