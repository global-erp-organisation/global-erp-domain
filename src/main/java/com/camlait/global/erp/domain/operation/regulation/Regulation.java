package com.camlait.global.erp.domain.operation.regulation;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.operation.regulation.lettering.BillRegulation;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "`op-regulations`")
public class Regulation extends Operation {

    @OneToMany(mappedBy = "regulation")
    private Collection<BillRegulation> billRegulations = Lists.newArrayList();

    @Transient
    private String regulationModeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "regulationModeId")
    private RegulationMode regulationMode;

    public Regulation() {
    }

    @Override
    public Regulation init() {
        setWorkerId(getWorker() == null ? null : getWorker().getPartnerId());
        setPartnerId(getPartner() == null ? null : getPartner().getPartnerId());
        setRegulationModeId(regulationMode == null ? null : regulationMode.getRegulationModeId());
        setBillRegulations(billRegulations == null ? Lists.newArrayList() : billRegulations.stream().map(br -> {
            return br.init();
        }).collect(Collectors.toList()));
        return this;
    }
}
