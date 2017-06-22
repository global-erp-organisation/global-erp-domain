package com.camlait.global.erp.controller;

import com.camlait.global.erp.validation.ResponseBuilder;

public class BaseController {

    public String genericMessage(String message) {
        return ResponseBuilder.builder().message(message).build().toJson();
    }
}
