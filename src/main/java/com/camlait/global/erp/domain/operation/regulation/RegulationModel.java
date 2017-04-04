package com.camlait.global.erp.domain.operation.regulation;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.BaseEntity;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.EvaluationMode;
import com.camlait.global.erp.domain.enumeration.RegulationCondition;
import com.camlait.global.erp.domain.helper.EntityHelper;
import com.camlait.global.erp.domain.partner.Partner;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
@Table(name = "`reg-regulation-models`")
public class RegulationModel extends BaseEntity {
    @Id
    private String modeleId;

    @Enumerated(EnumType.ORDINAL)
    private EvaluationMode modeEvaluation;
    private double value;
    private int numberOfDay;

    @Enumerated(EnumType.ORDINAL)
    private RegulationCondition regulationCondition;

    @Transient
    private String regulationModeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "regulationModeId")
    private RegulationMode regulationMode;

    @Transient
    private String partnerId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partnerId")
    private Partner partner;

    public RegulationModel() {
        super();
    }

    @PrePersist
    private void setKey() {
        setModeleId(EntityHelper.getUidFor(modeleId));
    }

    @Override
    public void postConstructOperation() {
        setRegulationModeId(regulationMode.getRegulationModeId());
    }

    @Override
    public EnumTypeEntitity toEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
