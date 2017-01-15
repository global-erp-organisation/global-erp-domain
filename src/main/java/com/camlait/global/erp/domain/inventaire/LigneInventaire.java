package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.produit.Produit;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LigneInventaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ligneInventaireId;

	@Transient
	private Long inventaireId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "inventaireId")
	private Inventaire inventaire;

	@Transient
	private Long produitId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteReelle;

	private Long quantiteAjustee;

	private double prixUnitaireReelle;

	private double prixUnitaireAjustee;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public LigneInventaire() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}
}
