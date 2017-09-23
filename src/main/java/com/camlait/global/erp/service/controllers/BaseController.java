package com.camlait.global.erp.service.controllers;

import com.camlait.global.erp.validation.ResponseBuilder;

public class BaseController {

    public String genericMessage(String message) {
        return message == null ? genericMessage() : ResponseBuilder.builder().message(message).build().toJson();
    }

    public String genericMessage() {
        return ResponseBuilder.builder().message("No message provided").build().toJson();
    }
}
