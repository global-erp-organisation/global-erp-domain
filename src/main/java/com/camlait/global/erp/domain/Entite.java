package com.camlait.global.erp.domain;

import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

public abstract class Entite {
    final MergeBeanUtilsBean bean = new MergeBeanUtilsBean();

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
