package com.camlait.global.erp.validation;

import java.util.List;

/**
 * Object validator interface.
 * 
 * @author Martin Blaise Signe
 * @param <T>
 */
public interface Validator<T,R> {
    ValidatorResult<R> validate(T toValidate);
    ValidatorResult<R> build(List<String> errors, R result);
}
