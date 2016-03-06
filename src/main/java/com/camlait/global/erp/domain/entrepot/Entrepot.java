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

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Centre;
import com.camlait.global.erp.domain.partenaire.Employe;
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
public class Entrepot extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entrepotId;

	@Column(name = "codeEntrepot", nullable = false, unique = true)
	private String codeEntrepot;

	private String descriptionEntrepot;

	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	@OneToMany(mappedBy = "entrepot")
	private Collection<Magasin> magasins;

	public Entrepot() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Entrepot(Long entrepotId, String codeEntrepot, String descriptionEntrepot, Centre centre,
			Date dateDeCreation, Date derniereMiseAJour, Employe responsable, Collection<Magasin> magasins) {
		super();
		this.entrepotId = entrepotId;
		this.codeEntrepot = codeEntrepot;
		this.descriptionEntrepot = descriptionEntrepot;
		this.centre = centre;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.responsable = responsable;
		this.magasins = magasins;
	}	
}
