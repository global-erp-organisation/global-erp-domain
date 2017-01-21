package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
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
@EqualsAndHashCode(callSuper = false)
@Builder
public class Emplois extends Entite {

	@Id
	private String emploisId;

	@Column(unique = true, nullable = false)
	private String codeEmplois;
	private String descriptionEmplois;

	@JsonManagedReference
	@OneToMany(mappedBy = "emplois")
	private Collection<Employe> employes = Sets.newHashSet();

	public Emplois() {
		super();
	}
	
	@PrePersist
	private void setKey() {
		setEmploisId(Utility.getUidFor(emploisId));
	}

	@Override
	public void postConstructOperation() {
	}

}
