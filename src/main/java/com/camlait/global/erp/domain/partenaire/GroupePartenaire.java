package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class GroupePartenaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupePartenaireId;

	private String descriptionGroupePartenaire;

	@OneToMany(mappedBy = "groupePartenaire")
	private Collection<Partenaire> partenaires;

	public GroupePartenaire(String descriptionGroupePartenaire) {
		super();
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
	}

	public GroupePartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupePartenaire(Long groupePartenaireId, String descriptionGroupePartenaire,
			Collection<Partenaire> partenaires) {
		super();
		this.groupePartenaireId = groupePartenaireId;
		this.descriptionGroupePartenaire = descriptionGroupePartenaire;
		this.partenaires = partenaires;
	}

}
