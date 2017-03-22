package com.camlait.global.erp.domain.util;

import java.util.UUID;

public final class Utility {

    public static String getUidFor(String currentKey) {
        return currentKey == null ? UUID.randomUUID().toString() : currentKey;
    }
}
