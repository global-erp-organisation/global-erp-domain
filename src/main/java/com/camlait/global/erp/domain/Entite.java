package com.camlait.global.erp.domain;

import java.io.Serializable;

import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

@SuppressWarnings("serial")
public abstract class Entite implements Serializable{
    private final MergeBeanUtilsBean bean = new MergeBeanUtilsBean();

    /**
     * Merge the current entity with the given one.
     * 
     * @param from
     * @return
     */
    public Entite merge(Entite from) {
        try {
            return bean.merge(from, this);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
