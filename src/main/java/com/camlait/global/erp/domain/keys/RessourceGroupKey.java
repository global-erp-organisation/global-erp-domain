package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.auth.Groupe;
import com.camlait.global.erp.domain.auth.Ressource;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class RessourceGroupKey implements Serializable {
    private Groupe groupe;

    private Ressource ressource;

    public RessourceGroupKey() {

    }
}
