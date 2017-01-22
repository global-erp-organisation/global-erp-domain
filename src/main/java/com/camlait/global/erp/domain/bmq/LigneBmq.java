package com.camlait.global.erp.domain.bmq;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude = "ligneBmqTaxes")
@Builder
@Table(name = "`bmq-ligne-bmqs`")
public class LigneBmq extends Entite {

	@Id
	private String ligneBmqId;

	@Transient
	private String produitId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

	private Long quantiteLigne;
	private double prixUnitaireLigne;

	@Transient
	private String bmqId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bmqId")
	private Bmq bmq;

	private Date dateDeCreation;

	private Date derniereMiseAJour;

	@Transient
	private String documentId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "documentId")
	private Document document;

	@JsonManagedReference
	@OneToMany(mappedBy = "ligneBmq", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LigneBmqTaxe> ligneBmqTaxes = Sets.newHashSet();

	public LigneBmq() {
	}

	public void setTaxe() {
		if (document != null && document.isDocumentCommerciaux()) {
			document.getLigneDocuments().parallelStream().forEach(ld -> {
				final Collection<LigneBmqTaxe> taxes = ld.getLigneDeDocumentTaxes().stream().map(lt -> {
					return LigneBmqTaxe.builder().ligneBmq(this).ligneBmqId(this.getLigneBmqId())
							.tauxDeTaxe(lt.getTauxDeTaxe()).taxe(lt.getTaxe()).taxeId(lt.getTaxeId()).build();
				}).collect(Collectors.toList());
				ligneBmqTaxes.addAll(taxes);
			});
		}
	}

	@Override
	public void postConstructOperation() {
		setProduitId(produit.getProduitId());
		setBmqId(bmq.getBmqId());
		setDocumentId(document.getDocumentId());
	}

	@PrePersist
	private void setKey() {
		setLigneBmqId(Utility.getUidFor(ligneBmqId));
		setTaxe();
		setDateDeCreation(new Date());
		setDerniereMiseAJour(new Date());
	}

	@PreUpdate
	private void preUpdate() {
		setDerniereMiseAJour(new Date());
	}
}
