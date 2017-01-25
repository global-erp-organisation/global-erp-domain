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

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name = "`trans-termes`")
public class Terme extends Entite {

    @Id
    private String termeId;

    @Column(unique = true, nullable = false)
    private String descriptionTerme;

    private Date dateDeCreation;
    private Date derniereMiseAJour;

    @JsonManagedReference
    @OneToMany(mappedBy = "terme", cascade = CascadeType.ALL)
    private Collection<TermeLangue> termeLangues = Sets.newHashSet();

    public Terme(String descriptionTerme) {
        super();
        this.descriptionTerme = descriptionTerme;
    }

    public Terme() {
        super();
    }

    @PrePersist
    private void setKey() {
        setTermeId(Utility.getUidFor(termeId));
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        setDerniereMiseAJour(new Date());
    }

    @Override
    public void postConstructOperation() {
    }

}
