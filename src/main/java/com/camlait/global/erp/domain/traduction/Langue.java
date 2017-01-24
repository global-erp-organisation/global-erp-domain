package com.camlait.global.erp.domain.traduction;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@EqualsAndHashCode(callSuper = false, exclude = "termeLangues")
@ToString(exclude = "termeLangues")
@Builder
@Table(name = "`trans-langue`")
public class Langue extends Entite {
    @Id
    private String langId;

    @Column(unique = true, nullable = false)
    private String codeLangue;

    private String title;

    private String alt;

    @JsonManagedReference
    @OneToMany(mappedBy = "langue", cascade = CascadeType.ALL)
    private Collection<TermeLangue> termeLangues = Sets.newHashSet();

    private Date dateDeCreation;
    private Date derniereMiseAJour;

    public Langue(String key, String title, String alt) {
        super();
        this.codeLangue = key;
        this.title = title;
        this.alt = alt;
    }

    public Langue() {
    }

    @PrePersist
    private void setKey() {
        setLangId(Utility.getUidFor(langId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        // TODO Auto-generated method stub
    }

}
