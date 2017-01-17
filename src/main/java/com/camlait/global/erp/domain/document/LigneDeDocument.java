package com.camlait.global.erp.domain.document;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LigneDeDocument extends Entite {

	@Id
	private String ligneDeDocumentId;

	@Transient
	private String produitId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteLigne;

	private double prixunitaiteLigne;
	@Transient
	private String documenId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "documentId")
	private Document document;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Enumerated(EnumType.STRING)
	private SensOperation sensOperation;

	@JsonManagedReference
	@OneToMany(mappedBy = "ligneDeDocument", fetch = FetchType.EAGER)
	private Collection<LigneDeDocumentTaxe> ligneDeDocumentTaxes = Sets.newHashSet();

	public LigneDeDocument() {
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());

	}

	public boolean isDisponible(LigneDeDocument ligne) {
		return this.getProduit().quantiteDisponible(this.getDocument().getMagasin()) - this.getQuantiteLigne() > 0;
	}
	
	@PrePersist
	private void setKey() {
		setLigneDeDocumentId(Utility.getUid());
	}
}
