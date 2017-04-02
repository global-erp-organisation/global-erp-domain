package com.camlait.global.erp.domain.operation.regulation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.regulation.lettering.BillRegulation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true, exclude = "billRegulations")
@ToString(exclude = "billRegulations")
@Table(name = "`op-regulations`")
public class Regulation extends Operation {

    @JsonManagedReference
    @OneToMany(mappedBy = "regulation")
    private Collection<BillRegulation> billRegulations = Lists.newArrayList();

    @Transient
    private String regulationModeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "regulationModeId")
    private RegulationMode regulationMode;

    public Regulation() {
    }

    @Override
    public void postConstructOperation() {
        setWorkerId(getWorker().getPartnerId());
        setPartnerId(getPartner().getPartnerId());
        setRegulationModeId(regulationMode.getRegulationModeId());
    }
}
