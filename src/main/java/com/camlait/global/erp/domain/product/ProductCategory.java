package com.camlait.global.erp.domain.product;

import java.util.Collection;
import java.util.stream.Collectors;

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
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"taxes", "categoryChildren", "products"})
@ToString(exclude = {"taxes", "categoryChildren", "products"})
@Builder
@Table(name = "`product-category-products`")
public class ProductCategory extends BaseEntity {

    @ApiModelProperty(hidden = true)
    @Id
    private String productCategoryId;

    @Transient
    private String parentCategoryId;

    @JsonIgnore
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

    @ApiModelProperty(hidden = true)
    @Builder.Default
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Collection<ProductCategory> categoryChildren = Lists.newArrayList();

    @ApiModelProperty(hidden = true)
    @Builder.Default
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Product> products = Lists.newArrayList();

    @ApiModelProperty(hidden = true)
    @Builder.Default
    @ManyToMany(mappedBy = "productCategories", cascade = CascadeType.ALL)
    private Collection<Tax> taxes = Lists.newArrayList();

    public void setCategorieParent(ProductCategory categorieParent) {
        this.parentCategory = categorieParent;
        parentTaxCopy(categorieParent);
    }

    public ProductCategory() {
    }

    public boolean isDetail() {
        return this.scope == Scope.DETAIL;
    }

    public boolean isTotal(ProductCategory categorie) {
        return this.scope == Scope.TOTAL;
    }

    private void parentTaxCopy(ProductCategory categorieParent) {
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
    public ProductCategory init() {
        setParentCategoryId(parentCategory == null ? null : parentCategory.getProductCategoryId());
        setProducts(products == null ? Lists.newArrayList() : products.stream().map(p -> {
            return p.init();
        }).collect(Collectors.toList()));
        setTaxes(taxes == null ? Lists.newArrayList() : taxes.stream().map(t -> {
            return t.init();
        }).collect(Collectors.toList()));
        setCategoryChildren(getCategoryChildren() == null ? Lists.newArrayList() : getCategoryChildren().stream().map(cc -> {
            return cc.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

    public ProductCategory addChildren(Collection<ProductCategory> children) {
        if (categoryChildren != null) {
            categoryChildren = Lists.newArrayList();
        }
        categoryChildren.addAll(children);
        return this;
    }

    public ProductCategory addChild(ProductCategory child) {
        if (categoryChildren != null) {
            categoryChildren = Lists.newArrayList();
        }
        categoryChildren.add(child);
        return this;
    }

    public ProductCategory addParent(ProductCategory parent) {
        setParentCategory(parent);
        Collection<ProductCategory> children = parent == null ? Lists.newArrayList() : parent.getCategoryChildren();
        if (children == null) {
            children = Lists.newArrayList();
        }
        children.add(this);
        return this;
    }

    public ProductCategory addCategoryToTax(Collection<Tax> tax) {
        if (CollectionUtils.isNullOrEmpty(taxes)) {
            setTaxes(tax);
        }
        taxes.forEach(t -> {
            Collection<ProductCategory> categories = t.getProductCategories();
            if (categories == null) {
                categories = Lists.newArrayList();
            }
            categories.add(this);
        });

        return this;
    }
}
