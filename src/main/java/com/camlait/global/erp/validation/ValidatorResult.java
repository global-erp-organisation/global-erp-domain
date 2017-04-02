package com.camlait.global.erp.validation;

public interface ValidatorResult<T, R> {
    T getErrors();
    R getResult();
}
