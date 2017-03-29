package com.camlait.global.erp.domain.operation.margin;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.operation.Operation;
import com.camlait.global.erp.domain.partner.MarginClient;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`op-marge-clients`")
public class ClientMarginOperation extends Operation {

    @Transient
    private String clientMargeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clientMargeId")
    private MarginClient client;

    public ClientMarginOperation() {
    }
}
