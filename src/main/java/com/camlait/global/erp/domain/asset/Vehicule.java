package com.camlait.global.erp.domain.asset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`asset-vehicules`")
public class Vehicule extends Asset {

    @Column(unique = true, nullable = false)
    private String vehiculeId;

    private String manufacturer;

    public Vehicule() {

    }
}
