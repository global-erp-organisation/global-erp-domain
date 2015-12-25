package com.camlait.global.erp.domain.inventaire;

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
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.partenaire.Magasinier;

@Entity
public class Inventaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long inventaireId;

	@Column(name = "codeInventaire", nullable = false, unique = true)
	private String codeInventaire;

	@Column(name = "dateInventaire", nullable = false)
	private Date dateInventaire;

	private String note;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = "magasinierSortantId")
	private Magasinier magasinierSortant;

	@ManyToOne
	@JoinColumn(name = "magasinierEntrantId")
	private Magasinier magasinierEntrant;

	private boolean inventaireClos;

	@OneToMany(mappedBy = "inventaire")
	private Collection<Document> documents;

	@OneToMany(mappedBy = "inventaire")
	private Collection<LigneInventaire> ligneInventaires;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	public Magasinier getMagasinierEntrant() {
		return magasinierEntrant;
	}

	public void setMagasinierEntrant(Magasinier magasinierEntrant) {
		this.magasinierEntrant = magasinierEntrant;
	}

	public String getCodeInventaire() {
		return codeInventaire;
	}

	public void setCodeInventaire(String codeInventaire) {
		this.codeInventaire = codeInventaire;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Magasinier getMagasinierSortant() {
		return magasinierSortant;
	}

	public void setMagasinierSortant(Magasinier magasinier) {
		this.magasinierSortant = magasinier;
	}

	public boolean isInventaireClos() {
		return inventaireClos;
	}

	public void setInventaireClos(boolean inventaireClos) {
		this.inventaireClos = inventaireClos;
	}

	public Collection<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}

	public Collection<LigneInventaire> getLigneInventaires() {
		return ligneInventaires;
	}

	public void setLigneInventaires(Collection<LigneInventaire> ligneInventaires) {
		this.ligneInventaires = ligneInventaires;
	}

	public Long getInventaireId() {
		return inventaireId;
	}

	public void setInventaireId(Long id) {
		this.inventaireId = id;
	}

	public Date getDateInventaire() {
		return dateInventaire;
	}

	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDerniereMiseAJour() {
		return derniereMiseAJour;
	}

	public void setDerniereMiseAJour(Date derniereMiseAJour) {
		this.derniereMiseAJour = derniereMiseAJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeInventaire == null) ? 0 : codeInventaire.hashCode());
		result = prime * result + ((inventaireId == null) ? 0 : inventaireId.hashCode());
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
		Inventaire other = (Inventaire) obj;
		if (codeInventaire == null) {
			if (other.codeInventaire != null)
				return false;
		} else if (!codeInventaire.equals(other.codeInventaire))
			return false;
		if (inventaireId == null) {
			if (other.inventaireId != null)
				return false;
		} else if (!inventaireId.equals(other.inventaireId))
			return false;
		return true;
	}

	public Inventaire() {

	}
}
