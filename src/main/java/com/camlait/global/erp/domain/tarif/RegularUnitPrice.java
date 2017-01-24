package com.camlait.global.erp.domain.tarif;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`tarif-regular-unit-prices`")
public class RegularUnitPrice extends UnitPrice {

    public RegularUnitPrice() {
    }
}
