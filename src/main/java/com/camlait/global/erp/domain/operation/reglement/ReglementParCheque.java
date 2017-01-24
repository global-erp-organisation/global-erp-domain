package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`reg-reglement-par-cheques`")
public class ReglementParCheque extends ModeDeReglement {

}
