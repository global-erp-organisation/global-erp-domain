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

import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.exception.LazyInitException;
import com.camlait.global.erp.domain.util.MergeUtil;
import com.camlait.global.erp.domain.util.SerializerUtil;

import lombok.NonNull;

/**
 * Entity base class
 * 
 * @author Martin Blaise Signe
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseEntity implements Serializable {

    /**
     * Help to perform all the post constructor operations.
     */
    @PostConstruct
    public abstract void postConstructOperation();

    /**
     * Convert this entity to an enumeration type.
     * 
     * @return The corresponding Enumeration if exist or null if not.
     */
    public abstract EnumTypeEntitity toEnum();

    /**
     * Merge the current entity with the one provided as parameter.
     * 
     * @param from
     * @return The merging object;
     * @see MergeUtil
     */
    public <T extends BaseEntity> T merge(@NonNull T from) {
        return (T) MergeUtil.mergeDefault(from, this);
    }

    /**
     * Verify if the given entity is the same type as the current entity.
     * 
     * @param clazz
     * @return
     */
    public <T extends BaseEntity> Boolean isTypeOf(@NonNull Class<T> clazz) {
        return this.getClass().getName().equals(clazz.getName());
    }

    /**
     * Scan the current entity in order to find all collection that need to be lazy
     * initialized then initialized them.
     * 
     * @return The current entity after lazy initialized collections.
     */
    public <T extends BaseEntity> T lazyInit() {
        Stream.of(this.getClass().getFields()).filter(this::canBeLazyInit).forEach(f -> Hibernate.initialize(getFieldValue(f)));
        return (T) this;
    }

    /**
     * Convert the current entity to a JSON format.
     * 
     * @return A string that represent a JSON value for the current entity.
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
        final Boolean isAnnotated = Stream.of(f.getDeclaredAnnotations()).anyMatch(a -> {
            return a.annotationType().isAssignableFrom(ManyToMany.class) || a.annotationType().isAssignableFrom(OneToMany.class);
        });
        return f.getType().isAssignableFrom(Collection.class) && isAnnotated;
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
