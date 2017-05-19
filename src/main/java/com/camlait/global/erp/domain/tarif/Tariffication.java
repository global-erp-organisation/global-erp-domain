package com.camlait.global.erp.domain.tarif;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.keys.TarifficationKey;
import com.camlait.global.erp.domain.localization.Zone;
import com.camlait.global.erp.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Table(name = "`tarif-tarifications`")
@IdClass(value = TarifficationKey.class)
public class Tariffication extends BaseEntity {

	@Transient
	private String zoneId;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

	@Transient
	private String productId;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@Transient
	private String tarifId;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name = "tarifId")
	private Tariff tarif;

	@Transient
	private String priceTypeId;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name = "priceTypeId")
	private PriceType priceType;

	private Double value;

	public Tariffication() {
	}

	@Override
	public Tariffication init() {
		setProductId(product == null ? null : product.getProductId());
		setZoneId(zone == null ? null : zone.getLocalId());
		setTarifId(tarif == null ? null : tarif.getTarifId());
		setPriceTypeId(priceType == null ? null : priceType.getPriceTypeId());
		return this;
	}

	@Override
	public EnumTypeEntitity toEnum() {
		return null;
	}
}
