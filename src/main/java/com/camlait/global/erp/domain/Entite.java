package com.camlait.global.erp.domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;

import com.camlait.global.erp.domain.util.MergeBeanUtilsBean;

import lombok.NonNull;

/**
 * Entity base class
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
	public <T> T merge(@NonNull T from) {
		return (T) MergeBeanUtilsBean.mergeDefault(from, this);
	}

	/**
	 * Help to perform all the post constructor operations.
	 */
	@PostConstruct
	public abstract void postConstructOperation();

	/**
	 * Verify if the given class is an instance of the current class.
	 * 
	 * @param clazz
	 * @return
	 */
	public <T> Boolean instanceOf(@NonNull Class<T> clazz) {
		return this.getClass().getName().equals(clazz.getName());
	}

	/**
	 * Scan the current class in order to find all collection that need to lazy
	 * initialize.
	 * 
	 * @return The Object after lazy initialized collections.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Entite> T lazyInit() {
		Stream.of(this.getClass().getFields()).filter(this::canBeLazyInit).forEach(f -> Hibernate.initialize(f));
		return (T) this;
	}

	private Boolean canBeLazyInit(Field f) {
		return (f.getAnnotation(ManyToMany.class) != null)
				|| (f.getAnnotation(OneToMany.class) != null) && (f.getType().isInstance(Collection.class));
	}
}
