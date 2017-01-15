package com.camlait.global.erp.domain.auth;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@AllArgsConstructor(suppressConstructorProperties=true)
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
	
	@JsonManagedReference
	@OneToMany(mappedBy="langue")
	private Collection<TermeLangue> termeLangues = Lists.newArrayList();
	
	public Langue(String key, String title, String alt) {
		super();
		this.codeLangue = key;
		this.title = title;
		this.alt = alt;
	}
	public Langue() {
	}	
}
