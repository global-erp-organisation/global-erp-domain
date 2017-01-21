package com.camlait.global.erp.domain.tarif;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name="`tarif-margin-unit-prices`")
@EqualsAndHashCode(callSuper = true)
public class MarginUnitPrice extends UnitPrice {

	public MarginUnitPrice(){
		
	}
}
