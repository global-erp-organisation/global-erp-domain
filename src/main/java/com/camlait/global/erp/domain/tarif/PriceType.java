package com.camlait.global.erp.domain.tarif;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name="`tarif-price-types`")
public class PriceType extends Entite {
	@Id
	private String priceTypeId;

	private String description;

	@JsonManagedReference
	@OneToMany(mappedBy = "priceType")
	private Collection<UnitPrice> unitPrices = Sets.newHashSet();

	public PriceType() {
	}

	@Override
	public void postConstructOperation() {
	}

}
