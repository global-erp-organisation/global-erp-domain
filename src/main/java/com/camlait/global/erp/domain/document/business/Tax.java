package com.camlait.global.erp.domain.document.business;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.product.ProductCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"products", "productCategories"})
@ToString(exclude = {"products", "productCategories"})
@Builder
@Table(name = "`tax-taxes`")
public class Tax extends BaseEntity {

    @Id
    @JsonProperty
    private String taxId;

    @JsonProperty
    @Column(unique = true, nullable = false)
    private String taxCode;

    private String taxDescription;

    private double percentageValue;

    @JsonIgnore
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-product-taxes`", joinColumns = {@JoinColumn(name = "`product-id`")}, inverseJoinColumns = {@JoinColumn(name = "`tax-id`")},
               uniqueConstraints = @UniqueConstraint(columnNames = {"`product-id`", "`tax-id`"}))
    private Collection<Product> products = Lists.newArrayList();

    @JsonIgnore
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-category-product-taxes`", joinColumns = {@JoinColumn(name = "`product-category-id`")},
               inverseJoinColumns = {@JoinColumn(name = "`tax-id`")},
               uniqueConstraints = @UniqueConstraint(columnNames = {"`product-category-id`", "`tax-id`"}))
    private Collection<ProductCategory> productCategories = Lists.newArrayList();

    public Tax() {
    }

    @PrePersist
    private void setKey() {
        setTaxId(EntityHelper.getUidFor(taxId));
    }

    @Override
    public Tax init() {
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

    public Tax addTaxToCategory(Collection<ProductCategory> categories) {
        if (CollectionUtils.isNullOrEmpty(productCategories)) {
            setProductCategories(categories);
        }
        productCategories.forEach(c -> {
            Collection<Tax> taxes = c.getTaxes();
            if (taxes == null) {
                taxes = Lists.newArrayList();
            }
            taxes.add(this);
        });
        return this;
    }

    public Tax addTaxToProduct(Collection<Product> pr) {
        if (CollectionUtils.isNullOrEmpty(products)) {
            setProducts(pr);
        }
        products.forEach(p -> {
            Collection<Tax> taxes = p.getTaxes();
            if (taxes == null) {
                taxes = Lists.newArrayList();
            }
            taxes.add(this);
        });
        return this;
    }
}
