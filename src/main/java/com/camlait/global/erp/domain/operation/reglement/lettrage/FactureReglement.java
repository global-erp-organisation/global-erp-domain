package com.camlait.global.erp.domain.operation.reglement.lettrage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.keys.FactureReglementKey;
import com.camlait.global.erp.domain.operation.reglement.Reglement;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`reg-facture-reglements`")
@IdClass(value = FactureReglementKey.class)
public class FactureReglement extends Entite {

    @Transient
    private String documentId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "documentId")
    private FactureClient facture;

    @Transient
    private String reglementId;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reglementId")
    private Reglement reglement;

    private Date dateDeVentilation;

    private Double montantVentile;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public FactureReglement() {
    }

    @PrePersist
    private void setKey() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setDocumentId(facture.getDocumentId());
        setReglementId(reglement.getOperationId());
    }
}
