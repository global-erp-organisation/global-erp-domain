package com.camlait.global.erp.domain.auth;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Langue extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long langId;

	@Column(unique = true, nullable = false)
	private String codeLangue;

	private String title;

	private String alt;
	
	@OneToMany(mappedBy="langue")
	private Collection<TermeLangue> termeLangues;
	

	public Long getLangId() {
		return langId;
	}

	public void setLangId(Long langId) {
		this.langId = langId;
	}

	public String getCodeLangue() {
		return codeLangue;
	}

	public void setCodeLangue(String codeLangue) {
		this.codeLangue = codeLangue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String descriptionLangue) {
		this.title = descriptionLangue;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	
	public Collection<TermeLangue> getTermeLangues() {
		return termeLangues;
	}

	public void setTermeLangues(Collection<TermeLangue> termeLangues) {
		this.termeLangues = termeLangues;
	}

	public Langue(String key, String title, String alt) {
		super();
		this.codeLangue = key;
		this.title = title;
		this.alt = alt;
	}
	public Langue() {
	}
}
