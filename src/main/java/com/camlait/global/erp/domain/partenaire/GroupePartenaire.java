package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

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

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class GroupePartenaire extends Entite {

	@Id
	private String groupePartenaireId;

	private String descriptionGroupePartenaire;

	@JsonManagedReference
	@OneToMany(mappedBy = "groupePartenaire")
	private Collection<Partenaire> partenaires = Sets.newHashSet();

	public GroupePartenaire(String descriptionGroupePartenaire) {
		super();
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
	}

	public GroupePartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PrePersist
	private void setKey() {
		setGroupePartenaireId(Utility.getUid());
	}
}
