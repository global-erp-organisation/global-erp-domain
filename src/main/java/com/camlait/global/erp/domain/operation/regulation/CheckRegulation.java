package com.camlait.global.erp.domain.operation.regulation;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`reg-check-regulations`")
public class CheckRegulation extends RegulationMode {

}
