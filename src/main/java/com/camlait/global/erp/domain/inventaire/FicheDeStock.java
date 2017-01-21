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
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name="`inv-fiche-de-stocks`")
public class FicheDeStock extends Entite {

    @Id
    private String ficheId;
    private Date dateFiche;
    
    @Transient
    private String magasinId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinId")
    private Magasin magasin;

    @Transient
    private String produitId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    public FicheDeStock() {
        super();
    }
    
	@PrePersist
	private void setKey() {
		setFicheId(Utility.getUidFor(ficheId));
	}

	@Override
	public void postConstructOperation() {
		setMagasinId(magasin.getMagasinId());
		setProduitId(produit.getProduitId());
	}
}
