package com.camlait.global.erp.domain.traduction;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`trans-terme-langues`")
public class TermeLangue extends Entite {

    @Id
    private String termeLangueId;

    @Transient
    private String termeId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "termeId")
    private Terme terme;

    @Transient
    private String langueId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "langueId")
    private Langue langue;

    private String translatedValue;
    private Date dateDeCreation;
    private Date derniereMiseAJour;

    public TermeLangue() {
        super();
    }

    public void setTermeId() {
        setTermeId(getTerme().getTermeId());
    }

    public void setLangueId() {
        setLangueId(getLangue().getLangId());
    }

    @PrePersist
    private void setKey() {
        setTermeLangueId(Utility.getUidFor(termeLangueId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
        setLangueId(langue.getLangId());
        setTermeId(terme.getTermeId());
    }
}
