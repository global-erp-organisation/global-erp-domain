package com.camlait.global.erp.domain.immobilisation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`immo-immobilisations`")
@EqualsAndHashCode(callSuper = false)
@Builder
public class Immobilisation extends Entite {

    @Id
    private String immoId;

    @Column(name = "codeImmo", nullable = false, unique = true)
    private String codeImmo;

    private Date dateAcquisition;

    private Date dateMiseEnService;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    private String descriptionImmo;

    public Immobilisation() {
    }

    @PrePersist
    private void setKey() {
        setImmoId(Utility.getUidFor(immoId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
    }
}
