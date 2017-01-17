package com.camlait.global.erp.domain.auth;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class GroupeUtilisateur extends Entite {

    @Id
    private String groupeUtilissateurId;

    @Transient
    private String groupeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "groupeId")
    private Groupe groupe;

    @Transient
    private String utilisateurId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur utilsateur;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    public GroupeUtilisateur() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    public void setUtilisateurId() {
        setUtilisateurId(getUtilsateur().getCodeUtilisateur());
    }

    public void setGroupeId() {
        setGroupeId(getGroupe().getGroupeId());
    }
    
	@PrePersist
	private void setKey() {
		setGroupeUtilissateurId(Utility.getUid());
	}
}
