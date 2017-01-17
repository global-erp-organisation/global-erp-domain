package com.camlait.global.erp.domain.auth.ressource;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor(suppressConstructorProperties=true)
@EqualsAndHashCode(callSuper = false)
@Builder
public class Langue extends Entite {
	@Id
	private String langId;

	@Column(unique = true, nullable = false)
	private String codeLangue;

	private String title;

	private String alt;
	
	@JsonManagedReference
	@OneToMany(mappedBy="langue")
	private Collection<TermeLangue> termeLangues = Sets.newHashSet();
	
	public Langue(String key, String title, String alt) {
		super();
		this.codeLangue = key;
		this.title = title;
		this.alt = alt;
	}
	public Langue() {
	}	
	
	@PrePersist
	private void setKey() {
		setLangId(Utility.getUid());
	}

}
