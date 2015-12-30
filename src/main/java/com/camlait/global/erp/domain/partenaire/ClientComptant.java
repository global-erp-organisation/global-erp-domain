package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.AutreEnum;

@Entity
public class ClientComptant extends Client {

	public ClientComptant() {
		setTypePartenaire(AutreEnum.CLIENT_COMPTANT);
	}
}
