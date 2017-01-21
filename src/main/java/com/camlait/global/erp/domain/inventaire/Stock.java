package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.produit.Produit;
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
@Table(name="`inv-stocks`")
public class Stock extends Entite {

    @Id
    private String stockId;

    @Transient
    private String produitId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    @Transient
    private String magasinId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinId")
    private Magasin magasin;

    private Long quantiteDisponible;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public Stock() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
	@PrePersist
	private void setKey() {
		setStockId(Utility.getUidFor(stockId));
	}

	@Override
	public void postConstructOperation() {
		setMagasinId(magasin.getMagasinId());
		setProduitId(produit.getProduitId());
	}
}
