package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Centre;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Entrepot extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entrepotId;

	@Column(name = "codeEntrepot", nullable = false, unique = true)
	private String codeEntrepot;

	private String descriptionEntrepot;

	@Transient
	private Long centreId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Transient
	private Long responsableId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	@JsonManagedReference
	@OneToMany(mappedBy = "entrepot")
	private Collection<Magasin> magasins = Lists.newArrayList();

	public Entrepot() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

}
