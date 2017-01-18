package com.camlait.global.erp.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

/**
 * Entity bas class
 * 
 * @author Martin Blaise Signe
 *
 */
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

	/**
	 * Help to perform all the post constructor operations.
	 */
	@PostConstruct
	public abstract void postConstructOperation();
}
