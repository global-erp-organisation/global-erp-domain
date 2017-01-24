package com.camlait.global.erp.domain.document;

import static com.camlait.global.erp.domain.config.GlobalAppConstants.unavailableProductMessage;

import java.util.Date;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.exception.DataStorageException;
import com.camlait.global.erp.domain.inventaire.Stock;
import com.camlait.global.erp.domain.produit.Produit;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = "ligneDeDocumentTaxes")
@ToString(exclude = "ligneDeDocumentTaxes")
@Builder
@Table(name = "`doc-ligne-de-documents`")
public class LigneDeDocument extends Entite {

    @Id
    private String ligneDeDocumentId;

    @Transient
    private String produitId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produitId")
    private Produit produit;

    private Long quantiteLigne;

    private double prixunitaiteLigne;

    @Transient
    private String documenId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentId")
    private Document document;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    @Enumerated(EnumType.STRING)
    private SensOperation sensOperation;

    @JsonManagedReference
    @OneToMany(mappedBy = "ligneDeDocument", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<LigneDeDocumentTaxe> ligneDeDocumentTaxes = Sets.newHashSet();

    @Transient
    @JsonIgnore
    private LigneDeDocument oldRecord;

    public LigneDeDocument() {
    }

    public boolean isStorable() {
        return this.getProduit().availableQuantity(this.getDocument().getMagasin()) - this.getQuantiteLigne() > 0;
    }

    @PrePersist
    private void setKey() {
        setLigneDeDocumentId(Utility.getUidFor(ligneDeDocumentId));
        setTaxe();
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
        setOldRecord(this);
    }

    public LigneDeDocument setTaxe() {
        if (document != null && document.isDocumentCommerciaux()) {
            if (isStorable()) {
                final Set<Taxe> taxes = this.getProduit().getTaxes();
                if (CollectionUtils.isNullOrEmpty(taxes)) {
                    final Set<LigneDeDocumentTaxe> lt = taxes.parallelStream().map(t -> {
                        return LigneDeDocumentTaxe.builder()
                                .dateDeCreation(new Date()).
                                derniereMiseAJour(new Date()).
                                ligneDeDocument(this)
                                .ligneDeDocumentId(this.getLigneDeDocumentId()).
                                tauxDeTaxe(t.getValeurPourcentage())
                                .taxe(t)
                                .taxeId(t.getTaxeId())
                                .build();
                    }).collect(Collectors.toSet());
                    setLigneDeDocumentTaxes(lt);
                }
            } else {
                throw new DataStorageException(unavailableProductMessage(this));
            }
        }
        return this;
    }

    @Override
    public void postConstructOperation() {
        setProduitId(produit.getProduitId());
        setDocumenId(document.getDocumentId());
    }

    @PreRemove
    private void setTheoldRecord() {
        setOldRecord(this);
    }

    @PostRemove
    private void postRemove() {
        if (oldRecord != null) {
            updateStock(getStock(), this.quantiteLigne, (s, q) -> {
                if (s != null) {
                    if (document.getSensOperation().equals(SensOperation.ENTREE)) {
                        s.setQuantiteDisponible(s.getQuantiteDisponible() - q);
                    } else {
                        s.setQuantiteDisponible(s.getQuantiteDisponible() + q);
                    }
                }
            });
            setOldRecord(null);
        }
    }

    @PostPersist
    private void postPersist() {
        updateStock(getStock(), this.quantiteLigne, (s, q) -> {
            if (s != null) {
                if (document.getSensOperation().equals(SensOperation.ENTREE)) {
                    s.setQuantiteDisponible(s.getQuantiteDisponible() + q);
                } else {
                    s.setQuantiteDisponible(s.getQuantiteDisponible() - q);
                }
            }
        });
    }

    @PostUpdate
    private void postUpdate() {
        if (oldRecord != null) {
            updateStock(getStock(), this.quantiteLigne, (s, q) -> {
                if (s != null) {
                    if (document.getSensOperation().equals(SensOperation.ENTREE)) {
                        s.setQuantiteDisponible(s.getQuantiteDisponible() - oldRecord.getQuantiteLigne() + q);
                    } else {
                        s.setQuantiteDisponible(s.getQuantiteDisponible() + oldRecord.getQuantiteLigne() - q);
                    }
                }
            });
            setOldRecord(null);
        }
    }

    private void updateStock(Stock stock, Long quantity, BiConsumer<Stock, Long> updateConsumer) {
        if (document.stockAffects()) {
            updateConsumer.accept(stock, quantity);
        }
    }

    private Stock getStock() {
        Stock s = this.getProduit().getStockByStore(document.getMagasin());
        if (s == null) {
            s = Stock.builder().magasin(document.getMagasin()).produit(getProduit()).quantiteDisponible(0L).build();
            this.getProduit().getStocks().add(s);
        }
        return s;
    }
}
