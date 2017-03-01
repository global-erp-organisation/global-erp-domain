package com.camlait.global.erp.domain.asset;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`asset-fridges`")
public class Fridge extends Asset {

    private String serailNumber;

    private String marque;

    public Fridge() {

    }
}
