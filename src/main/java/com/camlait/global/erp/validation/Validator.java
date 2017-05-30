package com.camlait.global.erp.validation;

import java.util.List;

/**
 * Object validation interface.
 * 
 * @author Martin Blaise Signe.
 * @param <T> Type of the object that need to be validate.
 * @param <R> Type of the object that need to be returned after validation.
 */
public interface Validator<T, R> {
    /**
     * Performs the validation of the provided object.
     * 
     * @param toValidate Object to validate.
     * @return An object that contains the list of detected errors and an object of type R for further usage
     * @see ValidatorResult
     */
    ValidatorResult<R> validate(T toValidate);

    /**
     * Build the validationResult object.
     * 
     * @param errors
     * @param result
     * @return
     * @see ValidatorResult
     */
    @SuppressWarnings("unchecked")
    default ValidatorResult<R> build(List<String> errors, R result){
         return (ValidatorResult<R>) ValidatorResult.builder(
                 ).errors(errors)
                 .result(result)
                 .build();
    }
    
   
}
