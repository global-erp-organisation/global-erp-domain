package com.camlait.global.erp.domain.product;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.inventory.Stock;
import com.camlait.global.erp.domain.inventory.StockCard;
import com.camlait.global.erp.domain.localization.Localization;
import com.camlait.global.erp.domain.tarif.PriceType;
import com.camlait.global.erp.domain.tarif.Tariff;
import com.camlait.global.erp.domain.tarif.Tariffication;
import com.camlait.global.erp.domain.warehouse.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"taxes", "stocks", "stockCards", "tarifications"})
@ToString(exclude = {"taxes", "stocks", "stockCards", "tarifications"})
@Builder
@Table(name = "`product-products`")
public class Product extends BaseEntity {

    @Id
    private String productId;

    @Column(unique = true, nullable = false)
    private String productCode;

    private String productDescription;

    @Transient
    private String productCategoryId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productCategoryId")
    private ProductCategory category;

    private boolean taxableProduct;

    private Double defaultUnitprice;

    @Builder.Default
    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Collection<Tax> taxes = Lists.newArrayList();

    private boolean stockFollowing;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<Stock> stocks = Lists.newArrayList();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<StockCard> stockCards = Lists.newArrayList();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<Tariffication> tarifications = Lists.newArrayList();

    public Product() {
    }

    public Long availableQuantity(Store m) {
        return this.getStocks().stream().filter(s -> s.getStore().getStoreId().equals(m.getStoreId())).mapToLong(s -> s.getAvailableQuantity()).sum();
    }

    public Boolean isAvailable(Store m, Long quantiteVoulue) {
        return availableQuantity(m) >= quantiteVoulue;
    }

    public void copieCategorieProduitTaxe() {
        if (category != null) {
            final Collection<Tax> ctaxes = category.getTaxes();
            if (!CollectionUtils.isNullOrEmpty(ctaxes) && CollectionUtils.isNullOrEmpty(taxes)) {
                setTaxes(taxes);
            }
        }
    }

    @PrePersist
    private void setKey() {
        setProductId(EntityHelper.getUidFor(productId));
    }

    @Override
    public Product init() {
        setProductCategoryId(category == null ? null : category.getProductCategoryId());
        setTarifications(tarifications == null ? Lists.newArrayList() : tarifications.stream().map(tf -> {
            return tf.init();
        }).collect(Collectors.toList()));
        setTaxes(taxes == null ? Lists.newArrayList() : taxes.stream().map(tx -> {
            return tx.init();
        }).collect(Collectors.toList()));
        setStockCards(stockCards == null ? Lists.newArrayList() : stockCards.stream().map(sc -> {
            return sc.init();
        }).collect(Collectors.toList()));
        setStocks(stocks == null ? Lists.newArrayList() : stocks.stream().map(s -> {
            return s.init();
        }).collect(Collectors.toList()));
        return this;
    }

    /**
     * Retrieve the unit price of the current product
     * 
     * @param type
     * @param zone
     * @param tarif
     * @return The unit price that belongs to the given price type, localization
     *         and the tariff.
     */
    public Double getUnitPrice(PriceType type, Localization zone, Tariff tariff) {
        if (type == null || CollectionUtils.isNullOrEmpty(tarifications)) {
            return defaultUnitprice;
        }
        final Optional<Tariffication> p = tarifications.stream().filter(t -> zone.getLocalId().equals(t.getZone().getLocalId()))
                .filter(t -> tariff.getTarifId().equals(t.getTarif().getTarifId()))
                .filter(t -> type.getPriceTypeId().equals(t.getPriceType().getPriceTypeId())).findFirst();
        return p.isPresent() ? p.get().getValue() : defaultUnitprice;
    }

    /**
     * Retrieve the stock of the current product for a specific store.
     * 
     * @param m
     *            given store.
     * @return
     */
    public Stock getStockByStore(Store store) {
        if (CollectionUtils.isNullOrEmpty(stocks)) {
            final Stock stock = Stock.builder().availableQuantity(0L).store(store).product(this).build();
            this.getStocks().add(stock);
            return stock;
        }
        return stocks.stream().filter(s -> store.getStoreId().equals(s.getStore().getStoreId())).findFirst().orElse(null);
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

    public Product addProductToCategory() {
        if (category != null) {
            Collection<Product> products = category.getProducts();
            if (products == null) {
                products = Lists.newArrayList();
            }
            products.add(this);
        }
        return this;
    }

    public Product addProductToTax(Collection<Tax> tx) {
        if (CollectionUtils.isNullOrEmpty(taxes)) {
            setTaxes(tx);
        }
        taxes.forEach(t -> {
            Collection<Product> products = t.getProducts();
            if (products == null) {
                products = Lists.newArrayList();
            }
            products.add(this);
        });
        return this;
    }
}
