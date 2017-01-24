package com.camlait.global.erp.domain.inventaire;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.partenaire.Magasinier;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"documents", "ligneInventaires"})
@ToString(exclude = {"documents", "ligneInventaires"})
@Builder
@Table(name = "`inv-inventaires`")
public class Inventaire extends Entite {

    @Id
    private String inventaireId;

    @Column(name = "codeInventaire", nullable = false, unique = true)
    private String codeInventaire;

    @Column(name = "dateInventaire", nullable = false)
    private Date dateInventaire;

    private String note;

    @Transient
    private String magasinId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinId")
    private Magasin magasin;

    @Transient
    private String magasinierSortantId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinierSortantId")
    private Magasinier magasinierSortant;

    @Transient
    private String magasinierEntrantId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinierEntrantId")
    private Magasinier magasinierEntrant;

    private boolean inventaireClos;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventaire", cascade = CascadeType.ALL)
    private Collection<Document> documents = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "inventaire", cascade = CascadeType.ALL)
    private Collection<LigneInventaire> ligneInventaires = Sets.newHashSet();

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public Inventaire() {
    }

    @PrePersist
    private void setKey() {
        setInventaireId(Utility.getUidFor(inventaireId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setMagasinId(magasin.getMagasinId());
        setMagasinierEntrantId(magasinierEntrant.getPartenaireId());
        setMagasinierSortantId(magasinierSortant.getPartenaireId());
    }
}
