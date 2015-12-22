package com.camlait.global.erp.domain.inventaire;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.partenaire.Magasinier;

@Entity
public class Inventaire extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventaireId")
	private Long id;

	@Column(name = "codeInventaire", nullable = false, unique = true)
	private String codeInventaire;

	@Column(name = "dateInventaire", nullable = false)
	private DateTime dateInventaire;

	private String note;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.MAGASIN_ID, insertable = false, updatable = false)
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = ClePrimaires.PARTENAIRE_ID, insertable = false, updatable = false)
	private Magasinier magasinier;

	@Column(name = "inventaireClos")
	private boolean inventaireClos;

	@OneToMany(mappedBy = "inventaire")
	private Collection<Document> documents;

	@OneToMany(mappedBy = "inventaire")
	private Collection<LigneInventaire> ligneInventaires;

	@Column(name = "dateDeCreation")
	private DateTime dateDeCreation;

	@Column(name = "derniereMiseAJour")
	private DateTime derniereMiseAJour;

	public Long getInventaireId() {
		return id;
	}

	public void setInventaireId(Long inventaireId) {
		this.id = inventaireId;
	}

	public String getCodeInventaire() {
		return codeInventaire;
	}

	public void setCodeInventaire(String codeInventaire) {
		this.codeInventaire = codeInventaire;
	}

	public DateTime getDateInventaire() {
		return dateInventaire;
	}

	public void setDateInventaire(DateTime dateInventaire) {
		this.dateInventaire = dateInventaire;
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

	public Magasinier getMagasinier() {
		return magasinier;
	}

	public void setMagasinier(Magasinier magasinier) {
		this.magasinier = magasinier;
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
		result = prime * result + ((codeInventaire == null) ? 0 : codeInventaire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Inventaire() {

	}
}
