package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.marge.MargeClient;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class ClientAmarge extends Client {

    @JsonManagedReference
	@OneToMany(mappedBy = "client")
	private Collection<MargeClient> margeClients = Sets.newHashSet();

	public ClientAmarge() {
		setTypePartenaire(TypePartenaire.CLIENT_A_MARGE);
	}
}