package com.camlait.global.erp.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;
import static org.apache.commons.lang.reflect.FieldUtils.readField;

import com.camlait.global.erp.domain.exception.LazyInitException;
import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

/**
 * Entity bas class
 * 
 * @author Martin Blaise Signe
 */
@SuppressWarnings("serial")
public abstract class Entite implements Serializable {
    /**
     * Merge the current entity with the given one.
     * 
     * @param from
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T merge(T from) {
        return (T) MergeBeanUtilsBean.mergeDefault(from, this);
    }

    /**
     * Help to perform all the post constructor operations.
     */
    @PostConstruct
    public abstract void postConstructOperation();

    /**
     * Scan the current class in order to find all collection that need to lazy initialize.
     * 
     * @return The Object after lazy initialized collections.
     */
    @SuppressWarnings("unchecked")
    public <T> T lazyInit() {
        Stream.of(this.getClass().getFields()).filter(f -> {
            return (f.getAnnotation(ManyToMany.class) != null) || (f.getAnnotation(OneToMany.class) != null) && (f.getType().isInstance(Collection.class));
        }).forEach(f -> {
            try {
                Hibernate.initialize(readField(this, f.getName(), true));
            } catch (Exception e) {
                throw new LazyInitException(e.getMessage(), e);
            }
        });
        return (T) this;
    }
}
