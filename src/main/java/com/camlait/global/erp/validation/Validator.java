package com.camlait.global.erp.validation;

import java.util.List;

/**
 * Object validator interface.
 * 
 * @author Martin Blaise Signe
 *
 * @param <T>
 */
public interface Validator<T> {
	List<String> validate(T toValidate);
}
