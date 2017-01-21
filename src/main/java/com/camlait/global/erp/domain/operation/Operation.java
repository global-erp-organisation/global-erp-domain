package com.camlait.global.erp.domain.operation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.camlait.global.erp.domain.util.Utility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Table(name="`op-operations`")
public class Operation extends Entite {

    @Id
    private String operationId;

    private Date dateOperation;

    @Enumerated(EnumType.STRING)
    private SensOperation sensOperation;

    private Date dateDeCreation;

    private Date derniereMiseAJour;

    private String libelleOperation;

    private double montantOperation;

    @Transient
    private String responsableId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "responsableId")
    private Employe responsable;

    @Transient
    private String partenaireId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partenaireId")
    private Partenaire partenaire;

    public Operation() {
        setDateDeCreation(new Date());
        setDerniereMiseAJour(new Date());
    }
    
	@PrePersist
	private void setKey() {
		setOperationId(Utility.getUidFor(operationId));
	}

	@Override
	public void postConstructOperation() {
		setResponsableId(responsable.getPartenaireId());
		setPartenaireId(partenaire.getPartenaireId());
	}
}
