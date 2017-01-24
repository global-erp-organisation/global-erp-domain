package com.camlait.global.erp.domain.entrepot;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.inventaire.FicheDeStock;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"ficheDeStocks", "stocks"})
@ToString(exclude = {"ficheDeStocks", "stocks"})
@Builder
@Table(name = "`ent-magasins`")
public class Magasin extends Entite {
    @Id
    private String magasinId;

    @Column(name = "codeMagasin", unique = true, nullable = false)
    private String codeMagasin;

    private String descriptionMagasin;

    @Transient
    private String entrepotId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrepotId")
    private Entrepot entrepot;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    @Enumerated(EnumType.STRING)
    private AutreEnum typeMagasin;

    @JsonManagedReference
    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    private Collection<Stock> stocks = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    private Collection<FicheDeStock> ficheDeStocks = Sets.newHashSet();

    public Magasin() {
    }

    @PrePersist
    private void setKey() {
        setMagasinId(Utility.getUidFor(magasinId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setEntrepotId(entrepot.getEntrepotId());
    }
}
