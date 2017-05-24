package com.camlait.global.erp.domain.inventory;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.InventoryDetailKey;
import com.camlait.global.erp.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`inv-inventory-details`")
@IdClass(value = InventoryDetailKey.class)
public class InventoryDetail extends BaseEntity {

	@Transient
	private String inventoryId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "inventoryId")
	private Inventory inventory;

	@Transient
	private String productId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "productId")
	private Product product;

	private Long realQuantity;

	private Long ajustQuantity;

	private double realUnitPrice;

	private double ajustUnitPrice;

	public InventoryDetail() {
	}

	@Override
	public InventoryDetail init() {
		setInventoryId(inventory == null ? null : inventory.getInventoryId());
		setProductId(product == null ? null : product.getProductId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}

}
