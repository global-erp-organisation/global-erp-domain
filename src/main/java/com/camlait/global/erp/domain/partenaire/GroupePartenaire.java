package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class GroupePartenaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupePartenaireId;

	private String descriptionGroupePartenaire;

	@JsonManagedReference
	@OneToMany(mappedBy = "groupePartenaire")
	private Collection<Partenaire> partenaires = Lists.newArrayList();

	public GroupePartenaire(String descriptionGroupePartenaire) {
		super();
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
	}

	public GroupePartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
}
