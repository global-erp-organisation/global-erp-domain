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

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.product.ProductCategory;
import com.camlait.global.erp.domain.util.EntityHelper;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"products", "productCategories"})
@ToString(exclude = {"products", "productCategories"})
@Builder
@Table(name = "`tax-taxes`")
public class Tax extends BaseEntity {

    @Id
    private String taxId;

    @Column(unique = true, nullable = false)
    private String taxCode;

    private String taxDescription;

    private double percentageValue;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-product-taxes`", joinColumns = {@JoinColumn(name = "`product-id`")}, inverseJoinColumns = {@JoinColumn(name = "`tax-id`")}
    ,uniqueConstraints = @UniqueConstraint(columnNames = {"`product-id`", "`tax-id`"}))
    private Collection<Product> products;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-category-product-taxes`", joinColumns = {@JoinColumn(name = "`product-category-id`")}, inverseJoinColumns = {@JoinColumn(name = "`tax-id`")}
    ,uniqueConstraints = @UniqueConstraint(columnNames = {"`product-category-id`", "`tax-id`"}))
    private Collection<ProductCategory> productCategories ;

 
    public Tax() {
    }

    @PrePersist
    private void setKey() {
        setTaxId(EntityHelper.getUidFor(taxId));
     }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

}
