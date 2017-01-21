package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name="`partenaire-groupe-partenaires`")
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
	}
	
	@PrePersist
	private void setKey() {
		setGroupePartenaireId(Utility.getUidFor(groupePartenaireId));
	}

	@Override
	public void postConstructOperation() {
	}
}
