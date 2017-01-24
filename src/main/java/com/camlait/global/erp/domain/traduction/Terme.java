package com.camlait.global.erp.domain.traduction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.util.Utility;

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
