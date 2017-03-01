package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.auth.Resource;
import com.camlait.global.erp.domain.auth.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@Builder
public class ResourceUserKey implements Serializable {
    private User user;
    private Resource resource;

    public ResourceUserKey() {
    }
}
