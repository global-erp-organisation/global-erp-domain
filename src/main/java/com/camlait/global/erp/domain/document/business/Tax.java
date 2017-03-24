package com.camlait.global.erp.domain.document.business;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.product.Product;
import com.camlait.global.erp.domain.product.ProductCategory;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private Date createdDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lasteUpdateddate;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-product-taxes`")
    private Collection<Product> products = Sets.newHashSet();

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`product-category-product-taxes`")
    private Collection<ProductCategory> productCategories = Sets.newHashSet();

 
    public Tax() {
    }

    @PrePersist
    private void setKey() {
        setTaxId(Utility.getUidFor(taxId));
        setCreatedDate(new Date());
        setLasteUpdateddate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setLasteUpdateddate(new Date());
    }

    @Override
    public void postConstructOperation() {
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }

}
