package com.camlait.global.erp.domain.partenaire;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partenaire-client-comptants`")
public class ClientComptant extends Client {

    public ClientComptant() {
        setTypePartenaire(TypePartenaire.CLIENT_COMPTANT);
    }
}
