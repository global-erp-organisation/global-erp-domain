package com.camlait.global.erp.domain.keys;

import java.io.Serializable;
import java.util.Date;

import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.warehouse.Store;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class StockCardKey implements Serializable {

    private Date stockDate;
    private Store store;
    private Product product;
}
