package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.config.ClePrimaires;
import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class Recouvrement extends Operation {

	@ManyToOne
	//@JoinColumns({ @JoinColumn(name = ClePrimaires.AUTO_ID), @JoinColumn(name = ClePrimaires.AUTO_ID), @JoinColumn(name = "dateBmq") })
	@JoinColumn(name=ClePrimaires.AUTO_ID,insertable=false,updatable=false)
	private Bmq bmq;

	public Recouvrement() {
		setSensOperation(SensOperation.ENTREE);
	}

}
