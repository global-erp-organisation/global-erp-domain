package com.camlait.global.erp.domain.inventaire;

import java.util.Collection;

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
    private int inventaireId;

    private String codeInventaire;

    private DateTime dateInventaire;

    private String note;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.MAGASIN_ID)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Magasinier magasinierSortant;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Magasinier magasinierEntrant;

    private boolean inventaireClos;

    @OneToMany(mappedBy = "inventaire")
    private Collection<Document> documents;

    @OneToMany(mappedBy = "inventaire")
    private Collection<LigneInventaire> ligneInventaires;

    public int getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(int inventaireId) {
        this.inventaireId = inventaireId;
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

    public Magasinier getMagasinierSortant() {
        return magasinierSortant;
    }

    public void setMagasinierSortant(Magasinier magasinierSortant) {
        this.magasinierSortant = magasinierSortant;
    }

    public Magasinier getMagasinierEntrant() {
        return magasinierEntrant;
    }

    public void setMagasinierEntrant(Magasinier magasinierEntrant) {
        this.magasinierEntrant = magasinierEntrant;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeInventaire == null) ? 0 : codeInventaire.hashCode());
        result = prime * result + inventaireId;
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
        }
        else if (!codeInventaire.equals(other.codeInventaire))
            return false;
        if (inventaireId != other.inventaireId)
            return false;
        return true;
    }

    public Inventaire() {

    }
}
