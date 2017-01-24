package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Partenaire;
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
@Table(name = "`immo-partenaire-immos`")
public class PartenaireImmobilisation extends Entite {

    @Id
    private String clientImmoId;

    @Transient
    private String partenaireId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partenaireId")
    private Partenaire partenaire;

    @Transient
    private String immoId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "immoId")
    private Immobilisation immobilisation;

    private Date dateAllocation;

    @Column(name = "actif")
    private boolean actif;

    private Date dateDeCreation;
    private Date derniereMiseAJour;

    public PartenaireImmobilisation() {
    }

    @PrePersist
    private void setKey() {
        setClientImmoId(Utility.getUidFor(clientImmoId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setPartenaireId(partenaire.getPartenaireId());
        setImmoId(immobilisation.getImmoId());
    }
}
