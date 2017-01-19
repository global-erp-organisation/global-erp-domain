package com.camlait.global.erp.domain.document.commerciaux.vente;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class FactureClient extends DocumentDeVente {

    @JsonManagedReference
    @OneToMany(mappedBy = "facture")
    private Collection<FactureReglement> factureReglements = Lists.newArrayList();

    public FactureClient() {
        setTypeDocument(TypeDocuments.FACTURE_CLIENT);
    }
    
}
