package com.camlait.global.erp.domain.partenaire;

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
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Emplois extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emploisId;

	@Column(unique = true, nullable = false)
	private String codeEmplois;
	private String descriptionEmplois;

	@JsonManagedReference
	@OneToMany(mappedBy = "emplois")
	private Collection<Employe> employes = Lists.newArrayList();

	public Emplois() {
		super();
	}
}
