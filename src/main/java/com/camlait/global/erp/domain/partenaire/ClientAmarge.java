package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.marge.MargeClient;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ClientAmarge extends Client {

	@OneToMany(mappedBy = "client")
	private Collection<MargeClient> margeClients;

	public Collection<MargeClient> getMargeClients() {
		return margeClients;
	}

	public void setMargeClients(Collection<MargeClient> margeClients) {
		this.margeClients = margeClients;
	}
	
	public ClientAmarge(){
		setTypePartenaire(TypePartenaire.CLIENT_A_MARGE);
	}
}
