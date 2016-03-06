package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.inventaire.FicheDeStock;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Magasin extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long magasinId;

	@Column(name = "codeMagasin", unique = true, nullable = false)
	private String codeMagasin;

	private String descriptionMagasin;

	@ManyToOne
	@JoinColumn(name = "entrepotId")
	private Entrepot entrepot;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Enumerated(EnumType.STRING)
	private AutreEnum typeMagasin;

	@OneToMany(mappedBy = "magasin")
	private Collection<Stock> stocks;

	@OneToMany(mappedBy = "magasin")
	private Collection<FicheDeStock> ficheDeStocks;

	public Magasin() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	public Magasin(Long magasinId, String codeMagasin, String descriptionMagasin, Entrepot entrepot,
			Date dateDeCreation, Date derniereMiseAJour, AutreEnum typeMagasin, Collection<Stock> stocks,
			Collection<FicheDeStock> ficheDeStocks) {
		super();
		this.magasinId = magasinId;
		this.codeMagasin = codeMagasin;
		this.descriptionMagasin = descriptionMagasin;
		this.entrepot = entrepot;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.typeMagasin = typeMagasin;
		this.stocks = stocks;
		this.ficheDeStocks = ficheDeStocks;
	}

}
