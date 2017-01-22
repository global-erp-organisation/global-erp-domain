package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

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
@Table(name = "`auth-groupes`")
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
	}

	@PrePersist
	private void prePersist() {
		setGroupeId(Utility.getUidFor(groupeId));
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}

	@Override
	public void postConstructOperation() {
	}
}
