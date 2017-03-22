package com.camlait.global.erp.domain.operation.regulation;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`reg-cash-regulations`")
public class CashRegulation extends RegulationMode {
}
