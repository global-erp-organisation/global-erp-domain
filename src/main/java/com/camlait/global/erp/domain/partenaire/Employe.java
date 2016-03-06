package com.camlait.global.erp.domain.partenaire;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.camlait.global.erp.domain.auth.Utilisateur;
import com.camlait.global.erp.domain.enumeration.Sexe;
import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Employe extends Partenaire {
    
    @Column(unique = true, nullable = false)
    private String matricule;
    
    @Column(nullable = false)
    private String nom;
    
    private String prenom;
    
    private Date dateDeNaissance;
    
    @OneToOne
    @JoinColumn(name = "codeUtilisateur")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "emploisId")
    private Emplois emplois;
    
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
        
    public Employe() {
        setTypePartenaire(TypePartenaire.EMPLOYE);
    }
}
