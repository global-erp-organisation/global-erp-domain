package com.camlait.global.erp.domain.partenaire;

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
public class Emplois extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emploisId;

	@Column(unique = true, nullable = false)
	private String codeEmplois;
	private String descriptionEmplois;

	@OneToMany(mappedBy = "emplois")
	private Collection<Employe> employes;

	public Emplois() {
		super();
	}

	public Emplois(Long emploisId, String codeEmplois, String descriptionEmplois, Collection<Employe> employes) {
		super();
		this.emploisId = emploisId;
		this.codeEmplois = codeEmplois;
		this.descriptionEmplois = descriptionEmplois;
		this.employes = employes;
	}

}
