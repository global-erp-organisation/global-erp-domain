package com.camlait.global.erp.domain.product;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazonaws.util.CollectionUtils;
import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.business.Tax;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.Scope;
import com.camlait.global.erp.domain.util.Helper;
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
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"taxes", "categoryChildren", "products"})
@ToString(exclude = {"taxes", "categoryChildren", "products"})
@Builder
@Table(name = "`produit-category-products`")
public class ProductCategory extends BaseEntity {

    @Id
    private String productcategoryId;

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

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdatedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Set<ProductCategory> categoryChildren = Sets.newHashSet();

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = Sets.newHashSet();

    @JsonManagedReference
    @ManyToMany(mappedBy = "productCategories", cascade = CascadeType.ALL)
    private Set<Tax> taxes = Sets.newHashSet();

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
        final Set<Tax> parentTaxes = categorieParent != null ? categorieParent.getTaxes() : null;
        if (!CollectionUtils.isNullOrEmpty(parentTaxes) && (taxes.isEmpty())) {
            setTaxes(parentTaxes);
        }
    }

    @PrePersist
    private void setKey() {
        setProductcategoryId(Helper.getUidFor(productcategoryId));
        setParentCategoryId(parentCategory != null ? parentCategory.getParentCategoryId() : null);
    }

    @PreUpdate
    private void preUpdate() {
        setLastUpdatedDate(new Date());
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
