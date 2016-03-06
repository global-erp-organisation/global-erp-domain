package com.camlait.global.erp.domain.document;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.produit.Produit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LigneDeDocument extends Entite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ligneDeDocumentId;
    
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;
    
    private Long quantiteLigne;
    
    private double prixunitaiteLigne;
    
    @ManyToOne
    @JoinColumn(name = "documentId")
    private Document document;
    
    private Date dateDeCreation;
    
    private Date derniereMiseAJour;
    
    @Enumerated(EnumType.STRING)
    private SensOperation sensOperation;
    
    @OneToMany(mappedBy = "ligneDeDocument", fetch=FetchType.EAGER)
    private Collection<LigneDeDocumentTaxe> ligneDeDocumentTaxes;
        
    public LigneDeDocument() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
        
    }

	public LigneDeDocument(Long ligneDeDocumentId, Produit produit, Long quantiteLigne, double prixunitaiteLigne,
			Document document, Date dateDeCreation, Date derniereMiseAJour, SensOperation sensOperation,
			Collection<LigneDeDocumentTaxe> ligneDeDocumentTaxes) {
		super();
		this.ligneDeDocumentId = ligneDeDocumentId;
		this.produit = produit;
		this.quantiteLigne = quantiteLigne;
		this.prixunitaiteLigne = prixunitaiteLigne;
		this.document = document;
		this.dateDeCreation = dateDeCreation;
		this.derniereMiseAJour = derniereMiseAJour;
		this.sensOperation = sensOperation;
		this.ligneDeDocumentTaxes = ligneDeDocumentTaxes;
	}
}
