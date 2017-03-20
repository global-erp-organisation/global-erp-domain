package com.camlait.global.erp.domain;

import static org.apache.commons.lang.reflect.FieldUtils.readField;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;

import com.camlait.global.erp.domain.exception.LazyInitException;
import com.camlait.global.erp.domain.util.MergeUtil;
import com.camlait.global.erp.domain.util.SerializerUtil;

import lombok.NonNull;

/**
 * Entity base class
 * 
 * @author Martin Blaise Signe
 */
@SuppressWarnings("serial")
public abstract class Entite implements Serializable {
    /**
     * Merge the current object with the one provided as parameter.
     * 
     * @param from
     * @return The merging object;
     * @see MergeUtil
     */
    @SuppressWarnings("unchecked")
    public <T extends Entite> T merge(@NonNull T from) {
        return (T) MergeUtil.mergeDefault(from, this);
    }

    /**
     * Help to perform all the post constructor operations.
     */
    @PostConstruct
    public abstract void postConstructOperation();

    /**
     * Verify if the given class is the same type as the current class.
     * 
     * @param clazz
     * @return
     */
    public <T extends Entite> Boolean isTypeOf(@NonNull Class<T> clazz) {
        return this.getClass().getName().equals(clazz.getName());
    }

    /**
     * Scan the current entity in order to find all collection that need to be lazy
     * initialized.
     * 
     * @return The Object after lazy initialized collections.
     */
    @SuppressWarnings("unchecked")
    public <T extends Entite> T lazyInit() {
        Stream.of(this.getClass().getFields())
        .filter(this::canBeLazyInit)
        .forEach(f -> Hibernate.initialize(getFieldValue(f)));
        return (T) this;
    }

    /**
     * Convert the current object to a Json format.
     * 
     * @return A string that represent a Json value for the current object.
     */
    public String toJson() {
        return SerializerUtil.toJson(this);
    }

    /**
     * Verify if the provided field can be lazy initialized or not.
     * 
     * @param f Field to verify.
     * @return true if the field can be lazy initialized and false otherwise.
     */
    private Boolean canBeLazyInit(Field f) {
        return (f.getType().isAssignableFrom(Collection.class)) && (f.getAnnotation(ManyToMany.class) != null) || (f.getAnnotation(OneToMany.class) != null);
    }

    /**
     * Retrieve the value of the provided field.
     * 
     * @param f Field that the value need to be retrieved.
     * @return An Object that represent the value of the provided field.
     */
    private Object getFieldValue(Field f) {
        try {
            return readField(this, f.getName(), true);
        } catch (Exception e) {
            throw new LazyInitException("Unable to get he field value. Field name: " + f.getName());
        }
    }
}
