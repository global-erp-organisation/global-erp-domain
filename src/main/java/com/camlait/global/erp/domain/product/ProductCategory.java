package com.camlait.global.erp.domain.product;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.camlait.global.erp.domain.enumeration.Scope;
import com.camlait.global.erp.domain.util.EntityHelper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"taxes", "categoryChildren", "products"})
@ToString(exclude = {"taxes", "categoryChildren", "products"})
@Builder
@Table(name = "`product-category-products`")
public class ProductCategory extends BaseEntity {

    @Id
    private String productCategoryId;

    @Transient
    private String parentCategoryId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentCategoryId")
    private ProductCategory parentCategory;

    @Column(unique = true)
    private String productCategoryCode;

    private String categoryDescription;

    @Enumerated(EnumType.STRING)
    private Scope scope;

    private boolean taxableCategory;

    private boolean stockFollowing;

    @JsonManagedReference
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Collection<ProductCategory> categoryChildren = Lists.newArrayList();

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Product> products = Lists.newArrayList();

    @JsonManagedReference
    @ManyToMany(mappedBy = "productCategories", cascade = CascadeType.ALL)
    private Collection<Tax> taxes = Lists.newArrayList();

    public void setCategorieParent(ProductCategory categorieParent) {
        this.parentCategory = categorieParent;
        copierTaxeParent(categorieParent);
    }

    public ProductCategory() {
    }

    public boolean isDetail() {
        return this.scope == Scope.DETAIL;
    }

    public boolean isTotal(ProductCategory categorie) {
        return !isDetail();
    }

    private void copierTaxeParent(ProductCategory categorieParent) {
        final Collection<Tax> parentTaxes = categorieParent != null ? categorieParent.getTaxes() : null;
        if (!CollectionUtils.isNullOrEmpty(parentTaxes) && (taxes.isEmpty())) {
            setTaxes(parentTaxes);
        }
    }

    @PrePersist
    private void setKey() {
        setProductCategoryId(EntityHelper.getUidFor(productCategoryId));
        setParentCategoryId(parentCategory == null ? null : parentCategory.getParentCategoryId());
    }

    @Override
    public void postConstructOperation() {
        setParentCategoryId(parentCategory.getParentCategoryId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
