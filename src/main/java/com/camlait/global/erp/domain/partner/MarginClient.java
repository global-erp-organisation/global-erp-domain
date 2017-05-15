package com.camlait.global.erp.domain.partner;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.operation.margin.ClientMarginOperation;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-margin-clients`")
public class MarginClient extends Client {

    @OneToMany(mappedBy = "client")
    private Collection<ClientMarginOperation> clientMargins = Lists.newArrayList();

    public MarginClient() {
        setPartnerType(PartnerType.MARGIN_CLIENT);
    }

    @Override
    public MarginClient init() {
        setClientMargins(clientMargins == null ? Lists.newArrayList() : clientMargins.stream().map(cmo -> {
            return cmo.init();
        }).collect(Collectors.toList()));
        return this;
    }
}
