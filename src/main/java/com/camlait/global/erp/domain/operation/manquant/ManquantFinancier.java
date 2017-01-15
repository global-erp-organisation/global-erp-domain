package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class ManquantFinancier extends Operation {

    @Transient
    private Long vendeurId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name="vendeurId")
	private Vendeur vendeur;
    
    public ManquantFinancier(){        
    }
}
