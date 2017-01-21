package com.camlait.global.erp.domain.document.commerciaux.vente;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.operation.reglement.lettrage.FactureReglement;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude="factureReglements")
@ToString(exclude="factureReglements")
public class FactureClient extends DocumentDeVente {

    @JsonManagedReference
    @OneToMany(mappedBy = "facture", cascade=CascadeType.ALL)
    private Collection<FactureReglement> factureReglements =Sets.newHashSet();

    public FactureClient() {
        setTypeDocument(TypeDocuments.FACTURE_CLIENT);
    }
    
}
