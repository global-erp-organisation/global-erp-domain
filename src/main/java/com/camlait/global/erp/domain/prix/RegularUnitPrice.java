package com.camlait.global.erp.domain.prix;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class RegularUnitPrice extends UnitPrice {
	
	public RegularUnitPrice(){		
	}
}
