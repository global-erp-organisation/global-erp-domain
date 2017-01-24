package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.caisse.Caisse;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Table(name = "`partenaire-caissiers`")
@EqualsAndHashCode(callSuper = true)
public class Caissier extends Employe {

    @Transient
    private String caisseId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "caisseId", updatable = false, insertable = false)
    private Caisse caisse;

    private String motDePasse;

    public Caissier() {
        setTypePartenaire(TypePartenaire.CAISSIER);
    }

    @Override
    public void postConstructOperation() {
        setCentreId(getCentre().getLocalId());
        setGroupePartenaireId(getGroupePartenaire().getGroupePartenaireId());
        setTarifId(getTarif().getTarifId());
        setCaisseId(caisse.getCaisseId());
    }

}
