package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.bmq.Bmq;
import static com.camlait.global.erp.domain.config.ClePrimaires.*;
import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class Recouvrement extends Operation {

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = MAGASIN_ID), @JoinColumn(name = PARTENAIRE_ID), @JoinColumn(name = "dateBmq") })
	private Bmq bmq;

	public Recouvrement() {
		setSensOperation(SensOperation.ENTREE);
	}

}
