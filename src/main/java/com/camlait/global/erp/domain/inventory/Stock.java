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
import com.camlait.global.erp.domain.keys.StockKey;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.warehouse.Store;
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
@Table(name = "`inv-stocks`")
@IdClass(value = StockKey.class)
public class Stock extends BaseEntity {

	@Transient
	private String productId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "productId")
	private Product product;

	@Transient
	private String storeId;

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "storeId")
	private Store store;

	private Long availableQuantity;

	public Stock() {
	}

	@Override
	public Stock init() {
		setStoreId(store == null ? null : store.getStoreId());
		setProductId(product == null ? null : product.getProductId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
