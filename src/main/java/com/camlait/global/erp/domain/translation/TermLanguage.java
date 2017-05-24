package com.camlait.global.erp.domain.translation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.TermLanguageKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "`trans-term-languages`")
@IdClass(value = TermLanguageKey.class)
public class TermLanguage extends BaseEntity {

	@Transient
	private String termId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "termId")
	private Term term;

	@Transient
	private String languageId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "languageId")
	private Language language;

	private String translatedValue;

	public TermLanguage() {
		super();
	}

	public void setTermeId() {
		setTermId(getTerm().getTermId());
	}

	public void setLangueId() {
		setLanguageId(getLanguage().getLangId());
	}

	@Override
	public TermLanguage init() {
		setLanguageId(language == null ? null : language.getLangId());
		setTermId(term == null ? null : term.getTermId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		// TODO Auto-generated method stub
		return null;
	}
}
