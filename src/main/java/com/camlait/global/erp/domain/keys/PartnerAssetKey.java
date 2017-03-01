package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.asset.Asset;
import com.camlait.global.erp.domain.partner.Partner;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class PartnerAssetKey implements Serializable {

    private Partner partner;
    private Asset asset;

    public PartnerAssetKey() {

    }
}
