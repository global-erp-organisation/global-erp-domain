package com.camlait.global.erp.domain.bmq;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LigneBmqTaxe extends Entite {
    @Id
    private String ligneBmqTaxeId;

    @Transient
    private String ligneBmqId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ligneBmqId")
    private LigneBmq ligneBmq;

    @Transient
    private String taxeId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "taxeId")
    private Taxe taxe;

    private double tauxDeTaxe;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public LigneBmqTaxe() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    public void setLigneBmqId() {
        setLigneBmqId(getLigneBmq().getLigneBmqId());
    }

    public void setTaxeId() {
        setTaxeId(getTaxe().getTaxeId());
    }
    
	@Override
	public void postConstructOperation() {
		setLigneBmqId(ligneBmq.getLigneBmqId());
		setTaxeId(taxe.getTaxeId());
	}
	
	@PrePersist
	private void setKey() {
		setLigneBmqTaxeId(Utility.getUid());
	}
}
