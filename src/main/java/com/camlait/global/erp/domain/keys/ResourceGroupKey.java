package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.auth.Group;
import com.camlait.global.erp.domain.auth.Resource;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ResourceGroupKey implements Serializable {
    private Group group;

    private Resource resource;

    public ResourceGroupKey() {

    }
}
