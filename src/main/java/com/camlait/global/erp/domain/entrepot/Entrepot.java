package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Centre;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Entrepot extends Entite {

	@Id
	private String entrepotId;

	@Column(name = "codeEntrepot", nullable = false, unique = true)
	private String codeEntrepot;

	private String descriptionEntrepot;

	@Transient
	private String centreId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Transient
	private String responsableId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "responsableId")
	private Employe responsable;

	@JsonManagedReference
	@OneToMany(mappedBy = "entrepot")
	private Collection<Magasin> magasins = Sets.newHashSet();

	public Entrepot() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
	
	@PrePersist
	private void setKey() {
		setEntrepotId(Utility.getUid());
	}

	@Override
	public void postConstructOperation() {
		setCentreId(centre.getLocalId());
		setResponsableId(responsable.getPartenaireId());
	}
}
