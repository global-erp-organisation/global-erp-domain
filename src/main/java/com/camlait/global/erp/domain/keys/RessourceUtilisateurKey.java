package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.auth.Ressource;
import com.camlait.global.erp.domain.auth.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@Builder
public class RessourceUtilisateurKey implements Serializable {
    private Utilisateur utilisateur;
    private Ressource ressource;

    public RessourceUtilisateurKey() {
    }
}
