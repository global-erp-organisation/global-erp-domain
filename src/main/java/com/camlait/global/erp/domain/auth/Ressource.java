package com.camlait.global.erp.domain.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor(suppressConstructorProperties = true)
public class Ressource extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ressourceId;

    @Transient
    private Long ressourceParentId;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ressourceParentId")
    private Ressource ressourceParent;

    private String title;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    private String icon;

    private String sref;

    private String href;

    private Integer ordre;

    @OneToMany(mappedBy = "ressourceParent", fetch = FetchType.EAGER)
    private Collection<Ressource> items;

    public Ressource() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    public Ressource(String descriptionMenu) {
        this.title = descriptionMenu;
    }

    public Ressource(String descriptionMenu, Ressource menuParent) {
        super();
        this.title = descriptionMenu;
        this.ressourceParent = menuParent;
    }
    
    public void setRessourceParentId(){
        setRessourceParentId(getRessourceParent().getRessourceId());
    }
}
