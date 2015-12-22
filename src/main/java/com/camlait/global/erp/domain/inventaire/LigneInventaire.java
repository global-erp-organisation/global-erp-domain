package com.camlait.global.erp.domain.inventaire;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.pk.PKLigneInventaire;
import com.camlait.global.erp.domain.produit.Produit;

@Entity
public class LigneInventaire extends Entite {

	@EmbeddedId
	private PKLigneInventaire ligneInventaireId;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Inventaire inventaire;

	@ManyToOne
	@JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
	private Produit produit;

	@Column(name = "quantiteReelle")
	private Long quantiteReelle;

	@Column(name = "quantiteAjustee")
	private Long quantiteAjustee;

	@Column(name = "prixUnitaireReelle")
	private double prixUnitaireReelle;

	@Column(name = "prixUnitaireAjustee")
	private double prixUnitaireAjustee;

	@Column(name = "dateDeCreation")
	private DateTime dateDeCreation;

	@Column(name = "derniereMiseAJour")
	private DateTime derniereMiseAJour;

	public PKLigneInventaire getLigneInventaireId() {
		return ligneInventaireId;
	}

	public void setLigneInventaireId(PKLigneInventaire ligneInventaireId) {
		this.ligneInventaireId = ligneInventaireId;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Long getQuantiteReelle() {
		return quantiteReelle;
	}

	public void setQuantiteReelle(Long quantiteReelle) {
		this.quantiteReelle = quantiteReelle;
	}

	public Long getQuantiteAjustee() {
		return quantiteAjustee;
	}

	public void setQuantiteAjustee(Long quantiteAjustee) {
		this.quantiteAjustee = quantiteAjustee;
	}

	public double getPrixUnitaireReelle() {
		return prixUnitaireReelle;
	}

	public void setPrixUnitaireReelle(double prixUnitaireReelle) {
		this.prixUnitaireReelle = prixUnitaireReelle;
	}

	public double getPrixUnitaireAjustee() {
		return prixUnitaireAjustee;
	}

	public void setPrixUnitaireAjustee(double prixUnitaireAjustee) {
		this.prixUnitaireAjustee = prixUnitaireAjustee;
	}

	public DateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(DateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public DateTime getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(DateTime derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ligneInventaireId == null) ? 0 : ligneInventaireId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneInventaire other = (LigneInventaire) obj;
		if (ligneInventaireId == null) {
			if (other.ligneInventaireId != null)
				return false;
		} else if (!ligneInventaireId.equals(other.ligneInventaireId))
			return false;
		return true;
	}

	public LigneInventaire() {

	}

}
