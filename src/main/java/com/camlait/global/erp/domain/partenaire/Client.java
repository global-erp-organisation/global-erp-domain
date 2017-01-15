package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends Partenaire {

    @Transient
    private Long zoneId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

    @JsonManagedReference
	@OneToMany(mappedBy = "client")
	private Collection<DocumentDeVente> documentDeVentes = Lists.newArrayList();

	private String description;

	private boolean clientAristourne;

	private double ristourne;

	public Client() {
		setTypePartenaire(TypePartenaire.CLIENT);
	}

}
