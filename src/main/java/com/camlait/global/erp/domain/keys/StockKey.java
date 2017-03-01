package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.warehouse.Store;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class StockKey implements Serializable {
    private Product product;
    private Store store;
}
