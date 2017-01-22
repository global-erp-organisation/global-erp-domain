package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "`inv-ligne-inventaires`")
public class LigneInventaire extends Entite {

	@Id
	private String ligneInventaireId;

	@Transient
	private String inventaireId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "inventaireId")
	private Inventaire inventaire;

	@Transient
	private String produitId;

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
	}

	@PrePersist
	private void setKey() {
		setLigneInventaireId(Utility.getUidFor(ligneInventaireId));
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}

	@Override
	public void postConstructOperation() {
		setInventaireId(inventaire.getInventaireId());
		setProduitId(produit.getProduitId());
	}

}
