package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(callSuper = false, exclude={"items","ressourceGroupes","ressourceUtilisateurs"})
@ToString(exclude={"items","ressourceGroupes","ressourceUtilisateurs"})
@Builder
@AllArgsConstructor(suppressConstructorProperties = true)
@Table(name="`auth-ressources`")
public class Ressource extends Entite {

	@Id
	private String ressourceId;

	@Transient
	private String ressourceParentId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ressourceParentId")
	private Ressource ressourceParent;

	private String title;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	private String icon;

	private String sref;

	private String href;

	private Integer ordre;

	@JsonManagedReference
	@OneToMany(mappedBy = "ressourceParent")
	private Collection<Ressource> items = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
	private Collection<RessourceGroupe> ressourceGroupes = Sets.newHashSet();

	@JsonManagedReference
	@OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
	private Collection<RessourceUtilisateur> ressourceUtilisateurs = Sets.newHashSet();

	public Ressource() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Ressource(String descriptionMenu) {
		this.title = descriptionMenu;
	}

	public Ressource(String descriptionMenu, Ressource menuParent) {
		super();
		this.title = descriptionMenu;
		this.ressourceParent = menuParent;
	}

	public void setRessourceParentId() {
		setRessourceParentId(getRessourceParent().getRessourceId());
	}

	public boolean possedeDetails() {
		return (!this.getItems().isEmpty());
	}

	@PrePersist
	private void setKey() {
		setRessourceId(Utility.getUidFor(ressourceId));
	}

	@Override
	public void postConstructOperation() {
		setRessourceParentId(ressourceParent.getRessourceId());
	}
}
