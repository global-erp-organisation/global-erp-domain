package com.camlait.global.erp.domain.document;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
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
public class LigneDeDocumentTaxe extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ligneDeDocumentTaxeId;

    @Transient
    private Long ligneDeDocumentId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ligneDeDocumentId")
    private LigneDeDocument ligneDeDocument;

    @Transient
    private Long taxeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "taxeId")
    private Taxe taxe;

    private double tauxDeTaxe;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public LigneDeDocumentTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
