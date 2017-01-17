package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class OperationDeCaisse extends Operation {

    @Transient
    private String journalId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "journalId")
    private JournalCaisse journal;
    
    public OperationDeCaisse(){
    }
}
