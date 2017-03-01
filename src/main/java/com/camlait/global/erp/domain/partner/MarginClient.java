package com.camlait.global.erp.domain.partner;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.operation.margin.ClientMargin;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-margin-clients`")
public class MarginClient extends Client {

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private Collection<ClientMargin> clientMargins = Sets.newHashSet();

    public MarginClient() {
        setPartnerType(PartnerType.CLIENT_A_MARGE);
    }
}
