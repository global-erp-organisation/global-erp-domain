package com.camlait.global.erp.domain.document;

import static com.camlait.global.erp.domain.config.GlobalAppConstants.unavailableProductMessage;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.exception.DataStorageExcetion;
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

	public boolean isStorable() {
		return this.getProduit().availableQuantity(this.getDocument().getMagasin()) - this.getQuantiteLigne() > 0;
	}

	@PrePersist
	private void setKey() {
		setLigneDeDocumentId(Utility.getUid());
		setTaxe();
	}
	
	@PostPersist
	public void updateStock(){
		if(document.stockAffects()){
			if(document.getSensOperation().equals(SensOperation.ENTREE)){
				
			}
			if(document.getSensOperation().equals(SensOperation.SORTIE)){
				
			}
		}
	}

	public void setTaxe() {
		if (document != null && document.isDocumentCommerciaux()) {
			if(isStorable()){
				final Collection<Taxe> taxes = this.getProduit().getTaxes();
				if (CollectionUtils.isNullOrEmpty(taxes)) {
					final Collection<LigneDeDocumentTaxe> lt = taxes.parallelStream().map(t->{
						return LigneDeDocumentTaxe.builder()
						.dateDeCreation(new Date())
						.derniereMiseAJour(new Date())
						.ligneDeDocument(this)
						.ligneDeDocumentId(this.getLigneDeDocumentId())
						.tauxDeTaxe(t.getValeurPourcentage())
						.taxe(t)
						.taxeId(t.getTaxeId())
						.build();
					}).collect(Collectors.toList());
					setLigneDeDocumentTaxes(lt);
				}
			}else{
				throw new DataStorageExcetion(unavailableProductMessage(this));
			}
		}
	}

	@Override
	public void postConstructOperation() {
		setProduitId(produit.getProduitId());
		setDocumenId(document.getDocumentId());
	}
}
