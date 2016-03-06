package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Ressource extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ressourceId;

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

	@OneToMany(mappedBy = "ressourceParent", fetch = FetchType.EAGER)
	private Collection<Ressource> items;

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

	public Ressource(Long ressourceId, Ressource ressourceParent, String title, Date dateDeCreation,
			Date derniereMiseAJour, String icon, String sref, String href, Integer ordre, Collection<Ressource> items) {
		super();
		this.ressourceId = ressourceId;
		this.ressourceParent = ressourceParent;
		this.title = title;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.icon = icon;
		this.sref = sref;
		this.href = href;
		this.ordre = ordre;
		this.items = items;
	}
}
