package com.camlait.global.erp.domain.dm;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = "dailyMovmentDetailTaxes")
@Builder
@Table(name = "`dm-daily-movement-details`")
public class DailyMovementDetail extends BaseEntity {

    @Id
    private String dmdId;

    @Transient
    private String productId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "productId")
    private Product product;

    private Long lineQuantity;
    private double lineUnitPrice;

    @Transient
    private String dmId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "dmId")
    private DailyMovement dailyMovement;

    @Transient
    private String documentId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "documentId")
    private Document document;

    @Builder.Default 
    @OneToMany(mappedBy = "dailyMovementDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<DailyMovmentDetailTax> dailyMovmentDetailTaxes = Lists.newArrayList();

    public DailyMovementDetail() {
    }

    /**
     * Built the tax details for the current object.
     * 
     * @return The current object with associated tax details.
     */
    public DailyMovementDetail buildTaxes() {
        if (document != null && document.isBusinessDocument()) {
            document.getDocumentDetails().stream().forEach(ld -> {
                final Collection<DailyMovmentDetailTax> taxes = ld.getDocumentDetailsTaxes().stream().map(lt -> {
                    return DailyMovmentDetailTax.builder().dailyMovementDetail(this).dmdId(this.getDmdId()).taxRate(lt.getTaxRate()).tax(lt.getTax())
                            .taxId(lt.getTaxId()).build();
                }).collect(Collectors.toList());
                dailyMovmentDetailTaxes.addAll(taxes);
            });
        }
        return this;
    }

    @Override
    public DailyMovementDetail init() {
        setProductId(product == null ? null : product.getProductId());
        setDmId(dailyMovement == null ? null : dailyMovement.getDmId());
        setDocumentId(document == null ? null : document.getDocumentId());
        setDailyMovmentDetailTaxes(dailyMovmentDetailTaxes == null ? Lists.newArrayList() : dailyMovmentDetailTaxes.stream().map(dmt -> {
            return dmt.init();
        }).collect(Collectors.toList()));
        return this;
    }

    @PrePersist
    @PreUpdate
    private void setKey() {
        setDmdId(EntityHelper.getUidFor(dmdId));
        buildTaxes();
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return null;
    }
}
