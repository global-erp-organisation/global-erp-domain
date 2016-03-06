package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.produit.Produit;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class FicheDeStock extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ficheId;
	private Date dateFiche;

	@ManyToOne
	@JoinColumn(name = "magasinId")
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	public FicheDeStock() {
		super();
	}

	public FicheDeStock(Long ficheId, Date dateFiche, Magasin magasin, Produit produit) {
		super();
		this.ficheId = ficheId;
		this.dateFiche = dateFiche;
		this.magasin = magasin;
		this.produit = produit;
	}
	
}
