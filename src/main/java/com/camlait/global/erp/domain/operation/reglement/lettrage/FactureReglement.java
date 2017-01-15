package com.camlait.global.erp.domain.operation.reglement.lettrage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.operation.reglement.Reglement;
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
public class FactureReglement extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long factureReglementId;

    @Transient
    private Long documentId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "documentId")
    private FactureClient facture;

    @Transient
    private Long reglementId;

    @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "reglementId")
    private Reglement reglement;

    private Date dateDeVentilation;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public FactureReglement() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
}
