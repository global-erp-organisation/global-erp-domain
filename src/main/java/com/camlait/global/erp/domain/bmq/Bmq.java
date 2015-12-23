package com.camlait.global.erp.domain.bmq;

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
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.operation.Recouvrement;
import com.camlait.global.erp.domain.partenaire.Vendeur;

@Entity
public class Bmq extends Entite {
    
    // @EmbeddedId
    // private PKBmq bmqId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String codeBmq;
    
    @Column(insertable = false, updatable = false)
    private Date dateBmq;
    
    @ManyToOne
    @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION, updatable = false, insertable = false)
    private Vendeur vendeur;
    
    @ManyToOne
    @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION, updatable = false, insertable = false)
    private Magasin magasin;
    
    @OneToMany(mappedBy = "bmq")
    private Collection<Document> documents;
    
    @OneToMany(mappedBy = "bmq")
    private Collection<Recouvrement> recouvrements;
    
    @OneToMany(mappedBy = "bmq")
    private Collection<LigneBmq> ligneBmqs;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    private boolean bmqClos;
    
    /*
     * public PKBmq getBmqId() { return bmqId; }
     * public void setBmqId(PKBmq bmqId) { this.bmqId = bmqId; }
     */
    
    public String getCodeBmq() {
        return codeBmq;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCodeBmq(String codeBmq) {
        this.codeBmq = codeBmq;
    }
    
    public Date getDateBmq() {
        return dateBmq;
    }
    
    public void setDateBmq(Date dateBmq) {
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
    
    public Collection<LigneBmq> getLigneBmqs() {
        return ligneBmqs;
    }
    
    public void setLigneBmqs(Collection<LigneBmq> ligneBmqs) {
        this.ligneBmqs = ligneBmqs;
    }
    
    public boolean isBmqClos() {
        return bmqClos;
    }
    
    public void setBmqClos(boolean bmqClos) {
        this.bmqClos = bmqClos;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Bmq other = (Bmq) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public Bmq() {
        // Fait rien
    }
}
