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
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.partenaire.Magasinier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Inventaire extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventaireId;

    @Column(name = "codeInventaire", nullable = false, unique = true)
    private String codeInventaire;

    @Column(name = "dateInventaire", nullable = false)
    private Date dateInventaire;

    private String note;

    @Transient
    private Long magasinId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinId")
    private Magasin magasin;

    @Transient
    private Long magasinierSortantId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinierSortantId")
    private Magasinier magasinierSortant;

    @Transient
    private Long magasinierEntrantId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinierEntrantId")
    private Magasinier magasinierEntrant;

    private boolean inventaireClos;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventaire")
    private Collection<Document> documents = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "inventaire")
    private Collection<LigneInventaire> ligneInventaires = Lists.newArrayList();

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public Inventaire() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
