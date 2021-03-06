package com.camlait.global.erp.domain.document.business.sale;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.operation.regulation.lettering.BillRegulation;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = "billRegulations")
@ToString(exclude = "billRegulations")
@Table(name = "`doc-bill-clients`")
public class ClientBill extends SaleDocument {

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Collection<BillRegulation> billRegulations = Lists.newArrayList();

    public ClientBill() {
        setDocumentType(DocumentType.CLIENT_BILL);
    }

    @Override
    public EnumTypeEntitity toEnum() {
        return DocumentType.CLIENT_BILL;
    }

    @Override
    public ClientBill init() {
        setBillRegulations(billRegulations == null ? Lists.newArrayList() : billRegulations.stream().map(br -> {
            return br.init();
        }).collect(Collectors.toList()));
        return this;
    }
}
