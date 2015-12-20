package com.camlait.global.erp.domain.bmq;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
import com.camlait.global.erp.domain.operation.Recouvrement;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.camlait.global.erp.domain.pk.PKBmq;

@Entity
public class Bmq extends Entite {

    @EmbeddedId
    private PKBmq bmqId;

    @Column(nullable = false, unique = true)
    private String codeBmq;

    private DateTime dateBmq;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.PARTENAIRE_ID)
    private Vendeur vendeur;

    @ManyToOne
    @JoinColumn(name = ClePrimaires.MAGASIN_ID)
    private Magasin magasin;

    @OneToMany(mappedBy = "bmq")
    private Collection<Document> documents;

    @OneToMany(mappedBy = "bmq")
    private Collection<Recouvrement> recouvrements;

    @OneToMany(mappedBy = "bmq")
    private Collection<LigneBmq> ligneBmqs;

    private DateTime dateDeCreation;

    private DateTime derniereMiseAJour;

    private boolean bmqClos;

    public PKBmq getBmqId() {
        return bmqId;
    }

    public void setBmqId(PKBmq bmqId) {
        this.bmqId = bmqId;
    }

    public String getCodeBmq() {
        return codeBmq;
    }

    public void setCodeBmq(String codeBmq) {
        this.codeBmq = codeBmq;
    }

    public DateTime getDateBmq() {
        return dateBmq;
    }

    public void setDateBmq(DateTime dateBmq) {
        this.dateBmq = dateBmq;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

    public Collection<Recouvrement> getRecouvrements() {
        return recouvrements;
    }

    public void setRecouvrements(Collection<Recouvrement> recouvrements) {
        this.recouvrements = recouvrements;
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

    public Collection<LigneBmq> getLigneBmqs() {
        return ligneBmqs;
    }

    public void setLigneBmqs(Collection<LigneBmq> ligneBmqs) {
        this.ligneBmqs = ligneBmqs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bmqId == null) ? 0 : bmqId.hashCode());
        result = prime * result + ((codeBmq == null) ? 0 : codeBmq.hashCode());
        return result;
    }

    public boolean isBmqClos() {
        return bmqClos;
    }

    public void setBmqClos(boolean bmqClos) {
        this.bmqClos = bmqClos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bmq other = (Bmq) obj;
        if (bmqId == null) {
            if (other.bmqId != null)
                return false;
        }
        else if (!bmqId.equals(other.bmqId))
            return false;
        if (codeBmq == null) {
            if (other.codeBmq != null)
                return false;
        }
        else if (!codeBmq.equals(other.codeBmq))
            return false;
        return true;
    }

    public Bmq() {
        // Fait rien
    }
}
