package com.camlait.global.erp.domain.bmq;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.produit.Produit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class LigneBmq extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ligneBmqId;

    @Transient
    private Long produitId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    private Long quantiteLigne;
    private double prixUnitaireLigne;

    @Transient
    private Long bmqId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bmqId")
    private Bmq bmq;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    @Transient
    private Long documentId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "documentId")
    private Document document;

    @JsonManagedReference
    @OneToMany(mappedBy = "ligneBmq", cascade = CascadeType.ALL)
    private Collection<LigneBmqTaxe> ligneBmqTaxes = Lists.newArrayList();

    public LigneBmq() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    public void setProduitId() {
        setProduitId(getProduit().getProduitId());
    }

    public void setBmqId() {
        setBmqId(getBmq().getBmqId());
    }

    public void setDocumentId() {
        setDocumentId(getDocument().getDocumentId());
    }

}
