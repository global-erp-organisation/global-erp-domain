package com.camlait.global.erp.domain.inventaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.entrepot.Magasin;
import com.camlait.global.erp.domain.produit.Produit;
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
public class FicheDeStock extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ficheId;
    private Date dateFiche;
    
    @Transient
    private Long magasinId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magasinId")
    private Magasin magasin;

    @Transient
    private Long produitId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    public FicheDeStock() {
        super();
    }

}
