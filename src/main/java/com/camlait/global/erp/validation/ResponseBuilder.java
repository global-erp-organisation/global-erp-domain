package com.camlait.global.erp.validation;

import com.camlait.global.erp.domain.helper.SerializerHelper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ResponseBuilder {
    private String message;

    public ResponseBuilder() {

    }

    public String toJson() {
        return SerializerHelper.toJson(this);
    }
}
