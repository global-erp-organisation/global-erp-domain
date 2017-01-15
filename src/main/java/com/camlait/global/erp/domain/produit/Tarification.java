package com.camlait.global.erp.domain.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Tarification extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tarificationId;

	@Transient
	private Long zoneId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zone;

	@Transient
	private Long produitId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	@Transient
	private long tarifId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "tarifId")
	private Tarif tarif;

	private double prixUnitaire;
	private double prixUnitaireMarge;

	public Tarification() {
	}
}
