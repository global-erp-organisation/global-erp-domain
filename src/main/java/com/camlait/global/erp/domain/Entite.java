package com.camlait.global.erp.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

@SuppressWarnings("serial")
public abstract class Entite implements Serializable {
	/**
	 * Merge the current entity with the given one.
	 * 
	 * @param from
	 * @return
	 */
	public Entite merge(Entite from) {
		return MergeBeanUtilsBean.mergeDefault(from, this);
	}
	
	@PostConstruct
	public abstract void postConstructOperation();
}
