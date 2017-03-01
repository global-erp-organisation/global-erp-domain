package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.localisation.Zone;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.tarif.Tarif;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TarificationKey implements Serializable {
    private Zone zone;
    private Product product;
    private Tarif tarif;
}
