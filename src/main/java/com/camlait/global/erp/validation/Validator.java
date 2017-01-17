package com.camlait.global.erp.validation;

import java.util.List;

/**
 * Object validator interface.
 * 
 * @author msigne
 *
 * @param <T>
 */
public interface Validator<T> {
	List<String> validate(T toValidate);
}
