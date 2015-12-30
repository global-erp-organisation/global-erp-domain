package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;

@Entity
public class ClientComptant extends Client {

	public ClientComptant() {
		setTypePartenaire(TypePartenaire.CLIENT_COMPTANT);
	}
}
