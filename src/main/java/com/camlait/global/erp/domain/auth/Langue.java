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

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
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
	
	public Langue(String key, String title, String alt) {
		super();
		this.codeLangue = key;
		this.title = title;
		this.alt = alt;
	}
	public Langue() {
	}
	public Langue(Long langId, String codeLangue, String title, String alt, Collection<TermeLangue> termeLangues) {
		super();
		this.langId = langId;
		this.codeLangue = codeLangue;
		this.title = title;
		this.alt = alt;
		this.termeLangues = termeLangues;
	}
	
}
