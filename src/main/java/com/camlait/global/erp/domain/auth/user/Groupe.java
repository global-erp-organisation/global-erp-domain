package com.camlait.global.erp.domain.auth.user;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false, exclude = { "ressourceGroupes", "utilisateurs" })
@ToString(exclude = { "ressourceGroupes", "utilisateurs" })
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Groupe extends Entite {

	@Id
	private String groupeId;

	private String descriptionGroupe;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@JsonManagedReference
	@OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
	private Collection<RessourceGroupe> ressourceGroupes = Sets.newHashSet();

	@JsonManagedReference
	@ManyToMany(mappedBy = "groupes", cascade = CascadeType.ALL)
	private Collection<Utilisateur> utilisateurs = Sets.newHashSet();

	public Groupe() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PrePersist
	private void setKey() {
		setGroupeId(Utility.getUidFor(groupeId));
	}

	@Override
	public void postConstructOperation() {
	}
}
