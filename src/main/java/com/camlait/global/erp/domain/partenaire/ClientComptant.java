package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.camlait.global.erp.domain.document.vente.FactureClientComptant;

@Entity
public class ClientComptant extends Client {

    @OneToMany(mappedBy = "client")
    private Collection<FactureClientComptant> factures;
    

}
