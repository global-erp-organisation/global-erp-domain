package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.inventory.Inventory;
import com.camlait.global.erp.domain.product.Product;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class InventoryDetailKey implements Serializable {
    private Inventory inventory;
    private Product product;
}
