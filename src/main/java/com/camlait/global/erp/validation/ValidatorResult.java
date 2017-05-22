package com.camlait.global.erp.validation;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

/**
 * Encapsulate the validation result
 * <ul>
 * <li>errors: List of string that represent the error messages after the validation</li>
 * <li>result: Generic type that represent a result to return after the validation.
 * </ul>
 * 
 * @author Martin Blaise Signe.
 * @param <R> type of the object to return after the validation.
 */
@Data
public class ValidatorResult<R> {
    private List<String> errors = Lists.newArrayList();
    private R result;
}
