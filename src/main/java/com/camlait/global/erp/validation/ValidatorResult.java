package com.camlait.global.erp.validation;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class ValidatorResult<R> {
    private List<String> errors = Lists.newArrayList();
    private R result;
}
