package com.camlait.global.erp.domain.operation.manquant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="`op-manquant-financiers`")
public class ManquantFinancier extends Operation {

    @Transient
    private String vendeurId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name="vendeurId")
	private Vendeur vendeur;
    
    public ManquantFinancier(){        
    }
    
	@Override
	public void postConstructOperation() {
		setResponsableId(getResponsable().getPartenaireId());
		setPartenaireId(getPartenaire().getPartenaireId());
		setVendeurId(vendeur.getPartenaireId());
	}
}
