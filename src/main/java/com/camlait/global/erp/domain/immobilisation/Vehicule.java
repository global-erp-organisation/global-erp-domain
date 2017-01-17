package com.camlait.global.erp.domain.immobilisation;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Vehicule extends Immobilisation {

    @Column(unique = true, nullable = false)
    private String immatriculation;

    private String marque;

    public Vehicule() {

    }
}
