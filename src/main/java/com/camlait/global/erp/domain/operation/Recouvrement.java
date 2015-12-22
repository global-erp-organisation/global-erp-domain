package com.camlait.global.erp.domain.operation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.enumeration.SensOperation;

@Entity
public class Recouvrement extends Operation {

	@ManyToOne
	//@JoinColumns({ @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION), @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION), @JoinColumn(name = "dateBmq") })
	@JoinColumn(name=GlobalAppConstants.AUTO_ID_NOTATION,insertable=false,updatable=false)
	private Bmq bmq;

	public Recouvrement() {
		setSensOperation(SensOperation.ENTREE);
	}

}
