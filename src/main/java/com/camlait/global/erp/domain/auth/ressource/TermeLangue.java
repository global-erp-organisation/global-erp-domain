package com.camlait.global.erp.domain.auth.ressource;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class TermeLangue extends Entite {

	@Id
	private String termeLangueId;

	@Transient
	private String termeId;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "termeId")
	private Terme terme;

	@Transient
	private String langueId;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "langueId")
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

	public TermeLangue(String termeLangueId, Terme terme, Langue langue, String value) {
		super();
		this.termeLangueId = termeLangueId;
		this.terme = terme;
		this.langue = langue;
		this.value = value;
	}

	public void setTermeId() {
		setTermeId(getTerme().getTermeId());
	}

	public void setLangueId() {
		setLangueId(getLangue().getLangId());
	}

	@PrePersist
	private void setKey() {
		setTermeLangueId(Utility.getUidFor(termeLangueId));
	}

	@Override
	public void postConstructOperation() {
		setLangueId(langue.getLangId());
		setTermeId(terme.getTermeId());
	}
}
