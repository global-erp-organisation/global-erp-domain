package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.enumeration.SensOperation;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Recouvrement extends Operation {

    @Transient
    private Long bmqId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bmqId")
	private Bmq bmq;

	public Recouvrement() {
		setSensOperation(SensOperation.ENTREE);
	}
}
