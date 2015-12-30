package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.operation.marge.MargeClient;

@Entity
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
		setTypePartenaire(AutreEnum.CLIENT_A_MARGE);
	}
}
